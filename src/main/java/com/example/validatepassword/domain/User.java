package com.example.validatepassword.domain;


import com.example.validatepassword.infra.RequestUser;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {

    @Column(unique = true)
    private String password;

    public User(RequestUser requestUser){
        this.password = requestUser.password();
    }
}
