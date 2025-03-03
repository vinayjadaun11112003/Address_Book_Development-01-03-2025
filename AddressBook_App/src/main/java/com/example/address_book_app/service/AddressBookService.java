package com.example.address_book_app.service;

import com.example.address_book_app.dto.AddressBookDTO;
import com.example.address_book_app.model.AddressBookEntry;
import com.example.address_book_app.repository.AddressBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

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


    //UC_ 01 & Uc_02  (Section -2)
    //only this method similar for Uc_03(Section -2)
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

    //Uc_02 (Section -2)
    public AddressBookEntry updateEntry(Long id, AddressBookDTO dto) {
        Optional<AddressBookEntry> existing = repository.findById(id);
        if (existing.isPresent()) {
            AddressBookEntry address = existing.get();
            address.setName(dto.getName());
            address.setPhone(dto.getPhone());
            address.setEmail(dto.getEmail());
            return repository.save(address);
        }
        return null;
    }

    public void deleteEntry(Long id) {
        repository.deleteById(id);
    }

    //Uc_03 (Section -2)
    private final List<AddressBookEntry> addressBookList = new ArrayList<>();
    private final AtomicLong counter = new AtomicLong(1);

    public AddressBookEntry getEntryById(Long id) {
        return addressBookList.stream()
                .filter(entry -> entry.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public AddressBookEntry createAddressEntry(AddressBookDTO dto) {
        AddressBookEntry address = new AddressBookEntry();
        //Assign unique ID
        address.setId(counter.getAndIncrement());
        address.setName(dto.getName());
        address.setPhone(dto.getPhone());
        address.setEmail(dto.getEmail());
        addressBookList.add(address);
        return address;
    }

    public AddressBookEntry modifyAddressEntry(Long id, AddressBookDTO dto) {
        Optional<AddressBookEntry> existing = addressBookList.stream()
                .filter(entry -> entry.getId().equals(id))
                .findFirst();

        existing.ifPresent(address -> {
            address.setName(dto.getName());
            address.setPhone(dto.getPhone());
            address.setEmail(dto.getEmail());
        });

        return existing.orElse(null);
    }

    public boolean removeAddressEntry(Long id) {
        return addressBookList.removeIf(entry -> entry.getId().equals(id));
    }
}
