package com.example.api.controller;

import com.example.api.model.Guardian;
import com.example.api.model.ListingGuardianDTO;
import com.example.api.model.GuardianDataInsertDTO;
import com.example.api.service.GuardianService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/alunos")
public class GuardianController {

    @Autowired
    private GuardianService guardianService;

    @GetMapping
    public List<ListingGuardianDTO> list(@RequestParam(value = "cpf", required = false) String cpf) {
        if (cpf != null && !cpf.isBlank()) {
            var searchedGuardian = this.guardianService.getGuardianByCpf(cpf);
            if (searchedGuardian != null) {
                return Collections.singletonList(searchedGuardian);
            }
            return null;
        }
        return this.guardianService.list();
    }

    @GetMapping("/{id}")
    public Guardian getAlunoPorId(@PathVariable("id") Long guardianId) {
        return this.guardianService.getGuardianById(guardianId);
    }

    @PostMapping
    public Guardian add(@RequestBody @Valid GuardianDataInsertDTO guardian) {
        var addGuardian = new Guardian(
                null,
                guardian.email(),
                guardian.fullName(),
                guardian.idCard(),
                guardian.cpf(),
                guardian.dateOfBirth(),
                guardian.phoneNumber(),
                guardian.gender());
        return this.guardianService.insertOrUpdate(addGuardian);
    }

    @PutMapping("/{id}")
    public Guardian update(@RequestBody Guardian guardian) {
        return this.guardianService.insertOrUpdate(guardian);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        this.guardianService.remove(id);
    }

}
