package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.entity.User;
import web.service.UserService;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    // Показ всех пользователей
    @GetMapping("/")
    public String showAllUsers(Model model) {
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "all-users";
    }

    // Форма для добавления нового пользователя
    @GetMapping("/addNewUser")
    public String addNewUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user-info";
    }

    // Сохранение нового или обновлённого пользователя
    @PostMapping("/saveUser")
    public String saveUser(@RequestParam(name = "id", required = false) Integer id,
                           @RequestParam("name") String name,
                           @RequestParam("email") String email) {
        User user = new User();
        if (id != null) {
            user.setId(id);
        }
        user.setName(name);
        user.setEmail(email);
        userService.saveUser(user);
        return "redirect:/";
    }

    // Форма для редактирования пользователя
    @GetMapping("/updateUser")
    public String updateUser(@RequestParam("id") Integer id, Model model) {
        User user = userService.getUser(id);
        model.addAttribute("user", user);
        return "user-info";
    }

    // Удаление пользователя
    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") Integer id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
