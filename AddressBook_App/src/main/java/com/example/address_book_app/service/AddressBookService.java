package com.example.address_book_app.service;

import com.example.address_book_app.dto.AddressBookDTO;
import com.example.address_book_app.model.AddressBookEntry;
import com.example.address_book_app.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService {

    private final AddressBookRepository repository;

    public AddressBookService(AddressBookRepository repository) {  // ✅ Constructor injection
        this.repository = repository;
    }

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


    //UC_ 01 (Section)
    public List<AddressBookEntry> getAllEntries() {
        return repository.findAll();
    }

    public AddressBookEntry addEntry(AddressBookDTO dto) {
        AddressBookEntry address = new AddressBookEntry();
        address.setName(dto.getName());
        address.setPhone(dto.getPhone());
        address.setEmail(dto.getEmail());
        return repository.save(address);
    }

}