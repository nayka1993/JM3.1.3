package springboot.korolev.springbootdem.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import springboot.korolev.springbootdem.model.User;



@Controller
public class UserController {


    @GetMapping(value = "/")
    public String getLoginPage() {
        return "redirect:/login";
    }

    @PreAuthorize(value = "hasAuthority('ADMIN') or hasAuthority('USER') or hasAuthority('ADMIN,USER')")
    @GetMapping(value = "/user")
    public String getUserPage(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("user", user);
        return "user";
    }
}
