package com.example.bank.demo.controller;


import com.example.bank.demo.modells.User;
import com.example.bank.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private UserService userService;


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
            userService.save(user);
            return "redirect:/";
        }


    }


}
