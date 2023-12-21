package com.example.api.model;
import java.util.Date;
import java.util.Calendar;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Guardian {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String fullName;
    private String idCard;
    private String cpf;
    private Date dateOfBirth;
    private String phoneNumber;
    private String gender;
    private String type;

    public Guardian(){
    }

    public Guardian(Long id,
    String email,String fullName,
    String idCard,String cpf,
    Date dateOfBirth,String phoneNumber,
    String gender){
        this.cpf = cpf;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.fullName = fullName;
        this.id = id;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
        this.type = "Responsável";
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getFullName(){
        return fullName;
    }

    public void setFullName(String fullName){
        this.fullName = fullName;
    }

    public String getIdCard(){
        return idCard;
    }

    public void setIdCard(String idCard){
        this.idCard = idCard;
    }

    public String getCpf(){
        return cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public Date getDateOfBirth(){
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth){
        this.dateOfBirth = dateOfBirth;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public String getGender(){
        return gender;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public String getType(){
        return type;
    }

    public Integer getAge(){
      Calendar today = Calendar.getInstance();
      Calendar birthCalendar = Calendar.getInstance();
      birthCalendar.setTime(dateOfBirth);

      int age = today.get(Calendar.YEAR) - birthCalendar.get(Calendar.YEAR);

      // Check if birthday has occurred this year
      if (today.get(Calendar.DAY_OF_YEAR) < birthCalendar.get(Calendar.DAY_OF_YEAR)) {
          age--; // Subtract 1 year if birthday hasn't occurred yet
      }

      return age;
    }
}
