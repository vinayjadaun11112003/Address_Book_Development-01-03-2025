package com.example.address_book_app.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressBookDTO {

    //Uc_01 (Section -2)
    private String name;
    private String phone;
    private String email;
}