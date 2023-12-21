package com.example.api.repository;

import com.example.api.model.Guardian;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuardianRepository extends JpaRepository<Guardian, Long> {

    //public Guardian findByCpfAndName(String cpf, String name);

    Guardian findByCpf(String cpf);
}
