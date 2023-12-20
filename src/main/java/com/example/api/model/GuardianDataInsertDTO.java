package com.example.api.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record GuardianDataInsertDTO(@NotEmpty String fullName, @NotBlank String email, String idCard, @NotBlank @Pattern(regexp = "\\\\d{3}\\\\.\\\\d{3}\\\\.\\\\d{3}-\\\\d{2}",
        message = "Cpf inválido! Deve ter 11 dígitos, seperados por . .")String cpf, @NotBlank java.util.Date dateOfBirth, String phoneNumber, String gender ) {
}
