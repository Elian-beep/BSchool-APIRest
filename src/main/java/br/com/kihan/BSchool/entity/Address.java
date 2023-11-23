package br.com.kihan.BSchool.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private String cep;
    private String state;
    private String city;
    private String neighborhood;
    private String street;
    private String service;
}
