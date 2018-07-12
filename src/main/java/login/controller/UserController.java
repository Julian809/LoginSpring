package login.controller;

import login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/login")
    public ModelAndView login(Model model, String error, String logout) {

        if (error != null) {
            model.addAttribute("error", "Your username and password is invalid.");
        }
        
        if (logout != null) {
            model.addAttribute("message", "You have been logged out successfully.");
        }

        ModelAndView modelAndView = new ModelAndView("/login.jsp");
        return modelAndView;
    }
    
    @GetMapping(value = {"/", "/home"})
    public String welcome(Model model) {
        
        return "home";
    }
}
