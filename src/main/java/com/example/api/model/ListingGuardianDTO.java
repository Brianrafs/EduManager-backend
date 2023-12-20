package com.example.api.model;
public record ListingGuardianDTO(Long id,
    String email,String fullName,
    String idCard,String cpf,
    java.util.Date dateOfBirth,String phoneNumber,
    String gender,String type){
    public ListingGuardianDTO(Guardian guardian){
        this(guardian.getId(),
        guardian.getEmail(),guardian.getFullName(),
        guardian.getIdCard(),guardian.getCpf(),
        guardian.getDateOfBirth(),guardian.getPhoneNumber(),
        guardian.getGender(),guardian.getType());
    }
}
