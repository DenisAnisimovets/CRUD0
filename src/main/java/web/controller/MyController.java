package web.controller;

import org.springframework.web.bind.annotation.*;
import web.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import web.service.UserService;

import java.util.List;

@Controller
public class MyController {
    @Autowired
    private UserService userService;

    @ModelAttribute("newUser")
    public User getPerson(){
        return new User();
    }
    @RequestMapping("/")
    public String showAllUsers(Model model){
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);

        return "all-users";

    }
    @RequestMapping("/addNewUser")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);

        return "user-info";

    }

    @RequestMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @PatchMapping("/{id}")
    public String updatePerson(@ModelAttribute("user") User updateuser){
        userService.saveUser(updateuser);
        return "redirect:/";
    }


    @GetMapping("/{id}/edit")
    public String updateInfo(@ModelAttribute("id") int id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user-info";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(@ModelAttribute("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
