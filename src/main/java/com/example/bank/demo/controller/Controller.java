package com.example.bank.demo.controller;


import com.example.bank.demo.modells.PrimaryAccount;
import com.example.bank.demo.modells.SavingsAccount;
import com.example.bank.demo.modells.User;
import com.example.bank.demo.modells.security.UserRole;
import com.example.bank.demo.repository.RoleRepository;
import com.example.bank.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;
import java.util.HashSet;
import java.util.Set;

@org.springframework.stereotype.Controller
public class Controller {


    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;

    @RequestMapping("/")
    public String home(){
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/signup",method = RequestMethod.GET)
    public String login(Model model){
        User user = new User();
        model.addAttribute(user);
        return "/signup";
    }

    @RequestMapping(value = "/signup",method = RequestMethod.POST)
    public  String signUp(@ModelAttribute("user") User user , Model model){

        if(userService.checkUserExists(user.getUsername(),user.getEmail())){
                if(userService.checkEmailExists(user.getEmail())){
                    model.addAttribute("emailExists",true);
                }
                if(userService.checkUsernameExists(user.getUsername())){
                    model.addAttribute("usernameExists",true);
                }
                return "signup";
        }else{
            Set<UserRole> userRoleSet = new HashSet<>();
            userRoleSet.add(new UserRole(user,roleRepository.findByName("ROLE_USER")));
            userService.createUser(user,userRoleSet);

            return "redirect:/";
        }


    }

    @RequestMapping(value = "/userFront",method = RequestMethod.GET)
    public String userFront(Principal principal, Model model){
        User user = userService.findByUserName(principal.getName());
        PrimaryAccount primaryAccount = user.getPrimaryAccount();
        SavingsAccount savingsAccount = user.getSavingsAccount();

        model.addAttribute("primaryAccount",primaryAccount);
        model.addAttribute("savingsAccount",savingsAccount);
        return "userFront";
    }


}
