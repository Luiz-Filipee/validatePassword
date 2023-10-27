package com.example.validatepassword.controller;

import com.example.validatepassword.domain.User;
import com.example.validatepassword.infra.RequestUser;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@RestController
@RequestMapping("/validate-password")
public class PasswordController {
    @PostMapping
    public ResponseEntity validatePassword(@RequestBody @Valid RequestUser data) {
        User user = new User(data);
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8,20}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(user.getPassword());
        if(m.matches()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.badRequest().body("not found");
        }
    }
}
