package com.example.validatepassword.infra;


import jakarta.validation.constraints.NotNull;

public record RequestUser (
        @NotNull
        String password){
}