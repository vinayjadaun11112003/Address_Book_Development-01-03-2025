package com.example.AddressBook_App.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/addressbook")
public class AddressBookController {

    @GetMapping("/welcome")
    public String welcomeMessage() {
        return "Welcome to Address Book App.";
    }
}
