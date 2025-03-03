package com.example.AddressBook_App.controller;
import com.example.AddressBook_App.service.AddressBookService;
import com.example.AddressBook_App.model.AddressBookEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/addressbook")
public class AddressBookController {

    //UC_01
    @GetMapping("/welcome")
    public String welcomeMessage() {
        return "Welcome to Address Book App.";
    }


    //UC_02
    @Autowired
    private AddressBookService service;

    @GetMapping
    public ResponseEntity<List<AddressBookEntry>> getAllContacts() {
        return ResponseEntity.ok(service.getAllContacts());
    }
    @GetMapping("/{id}")
    public ResponseEntity<AddressBookEntry> getContactById(@PathVariable Long id) {
        Optional<AddressBookEntry> contact = service.getContactById(id);
        return contact.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<AddressBookEntry> addContact(@RequestBody AddressBookEntry entry) {
        return ResponseEntity.ok(service.saveContact(entry));
    }
    @PutMapping("/{id}")
    public ResponseEntity<AddressBookEntry> updateContact(@PathVariable Long id, @RequestBody AddressBookEntry entry) {
        AddressBookEntry updated = service.updateContact(id, entry);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        service.deleteContact(id);
        return ResponseEntity.noContent().build();
    }
}