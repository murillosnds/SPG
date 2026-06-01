package github.murillosnds.spg.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import github.murillosnds.spg.service.PasswordService;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class PasswordController {

    private final PasswordService passwordService;

    public PasswordController(PasswordService passwordService) {
        this.passwordService = passwordService;
    }

    @GetMapping("/api/password")
    public String generatePassword(@RequestParam(defaultValue = "12") int length) {
        return passwordService.generatePassword(length);
    }
}
