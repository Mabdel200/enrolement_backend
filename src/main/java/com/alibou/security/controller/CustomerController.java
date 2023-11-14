package com.alibou.security.controller;

import com.alibou.security.entities.Customer;
import com.alibou.security.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor

public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/addCustomer")
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){

        if(customer == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        Customer customer1 = customerRepository.save(customer);
        return new ResponseEntity<>(customer1, HttpStatus.OK);
    }

    @GetMapping("/findAllCustomers")
    public List<Customer> getAllCustomer(){
        return customerRepository.findAll();
    }


}
