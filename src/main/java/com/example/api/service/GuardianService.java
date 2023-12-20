package com.example.api.service;

import com.example.api.model.Guardian;
import com.example.api.model.ListingGuardianDTO;
import com.example.api.repository.GuardianRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuardianService {

    @Autowired
    private GuardianRepository guardianRepository;

    public List<ListingGuardianDTO> list() {
        return this.guardianRepository.findAll().stream().map(ListingGuardianDTO::new).toList();
    }

    public Guardian getGuardianById(Long id) {
        return this.guardianRepository.findById(id).orElse(null);
    }

    @Transactional
    public Guardian insertOrUpdate(Guardian guardian) {
        var guardianInserted = this.guardianRepository.save(guardian);

        if (guardian.getAge() < 18) {
            throw new InvalidAgeException("O Responsável não pode ser menor de idade!");
        }
        if (guardian.getFullName().equals("teste")) {
            throw new RuntimeException();
        }

        guardian.setFullName(guardian.getFullName() + " - alterado");
        return guardianInserted;
    }

    public void remove(Long id) {
        this.guardianRepository.deleteById(id);
    }

    public ListingGuardianDTO getGuardianByCpf(String cpf) {
        var searchedGuardian = this.guardianRepository.findByCpf(cpf);
        if (searchedGuardian != null) {
            return new ListingGuardianDTO(searchedGuardian);
        }
        return null;
    }
}
