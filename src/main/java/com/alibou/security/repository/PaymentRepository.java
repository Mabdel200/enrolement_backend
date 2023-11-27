package com.alibou.security.repository;

import com.alibou.security.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    public List<Payment> findByDateDePaiement(LocalDate date);
}
