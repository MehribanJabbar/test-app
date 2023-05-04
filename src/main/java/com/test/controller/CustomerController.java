package com.test.controller;

import com.test.model.Customer;
import com.test.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/addCustomer")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        Customer addCustomer=customerService.addCustomer(customer);
        return new ResponseEntity<Customer>(addCustomer, HttpStatus.CREATED);
    }

    @GetMapping("/allCustomer")
    public ResponseEntity<List<Customer>> findAllCustomer(){
        List<Customer> allCustomer=customerService.getAllCustomer();
        return new ResponseEntity<List<Customer>>(allCustomer, HttpStatus.OK);
    }

    @GetMapping("/getCustomer/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id){
        Customer getCustomerById=customerService.getCustomerById(id);
        return new ResponseEntity<Customer>(getCustomerById, HttpStatus.OK);
    }

    @DeleteMapping("/deleteCustomer/{id}")
    public ResponseEntity<Void> deleteCustomerById(@PathVariable("id") Long id){
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }
}
