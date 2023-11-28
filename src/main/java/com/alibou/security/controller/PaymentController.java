package com.alibou.security.controller;

import com.alibou.security.entities.Payment;
import com.alibou.security.entities.User;
import com.alibou.security.repository.CustomerRepository;
import com.alibou.security.repository.PaymentRepository;
import com.alibou.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor

public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/addPayment")
    public ResponseEntity<Payment> savePayment(@RequestBody Payment payment){

        if (payment == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        Payment savePayment = paymentRepository.save(payment);
        return new ResponseEntity<>(savePayment, HttpStatus.OK);
    }

    @GetMapping("/findAllPayment")
    public List<Payment> getAllPayment(){
        return paymentRepository.findAll();
    }

    @GetMapping("/findPaymentById/{id}")
    public ResponseEntity<Payment> getPaymentById(@PathVariable("id") Long id){

        Payment paymentFromDb = paymentRepository.findById(id).orElse(null);
        if(paymentFromDb == null){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(paymentFromDb, HttpStatus.OK);
    }

    @GetMapping("/findAllPaymentByUser/{id}")
    public List<Payment> getAllPaymentById(@PathVariable("id") int id){

        List<Payment> paymentList = new ArrayList<>();
        User user = userRepository.findById(id).orElse(null);
        for (Payment payment : paymentRepository.findAll()){
            if (payment.getUser().getId() == user.getId()){
                paymentList.add(payment);
            }
        }

        return paymentList;
    }

    @DeleteMapping("/dropPayment/{id}")
    public String deletePayment(@PathVariable("id") Long id){
        paymentRepository.deleteById(id);
        return "Deleted with Successfully from database";
    }

}
