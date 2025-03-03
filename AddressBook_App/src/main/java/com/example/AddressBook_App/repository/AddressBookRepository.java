package com.example.AddressBook_App.repository;


import com.example.AddressBook_App.model.AddressBookEntry;
import org.springframework.data.jpa.repository.JpaRepository;


//UC_02
public interface AddressBookRepository extends JpaRepository<AddressBookEntry, Long> {
}