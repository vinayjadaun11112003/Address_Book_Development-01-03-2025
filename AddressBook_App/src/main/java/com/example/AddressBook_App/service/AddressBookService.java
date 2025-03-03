package com.example.AddressBook_App.service;


import com.example.AddressBook_App.model.AddressBookEntry;
import com.example.AddressBook_App.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService {

    //Uc_02
    @Autowired
    private AddressBookRepository repository;

    public List<AddressBookEntry> getAllContacts() {
        return repository.findAll();
    }

    public Optional<AddressBookEntry> getContactById(Long id) {
        return repository.findById(id);
    }

    public AddressBookEntry saveContact(AddressBookEntry entry) {
        return repository.save(entry);
    }

    public AddressBookEntry updateContact(Long id, AddressBookEntry updatedEntry) {
        return repository.findById(id).map(existing -> {
            existing.setName(updatedEntry.getName());
            existing.setPhone(updatedEntry.getPhone());
            existing.setEmail(updatedEntry.getEmail());
            return repository.save(existing);
        }).orElse(null);
    }

    public void deleteContact(Long id) {
        repository.deleteById(id);
    }
}