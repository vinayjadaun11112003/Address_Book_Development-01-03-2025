package com.example.address_book_app.repository;


import com.example.address_book_app.model.AddressBookEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//UC_02
//Uc_01 (Section -2)
@Repository
public interface AddressBookRepository extends JpaRepository<AddressBookEntry, Long> {
}