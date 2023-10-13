package com.voterManagement.work.voterCardManagement.entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

@Entity
@Table(name= "voter")
public class Voter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "First Name cannot be blank")
    @Size(min = 3, message = "Size must be greater than 3")
    @Column(name = "firstname")
    private String firstName;
    @NotBlank(message = "Last Name cannot be blank")
    @Size(min = 3, message = "Size must be greater than 3")
    @Column(name = "lastname")
    private String lastName;

    @NotNull(message = "Age should be Greater than 18")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "dob")
    private LocalDate dob;

    @NotBlank(message = "Nationality cannot be blank")
    @Size(min = 3, message = "Size must be greater than 3")
    @Column(name = "nationality")
    private String nationality;

    @Column(name = "state_id")
    private int state_id;

    @Column(name = "statename")
    private String stateNames;
    @NotNull(message = "Pincode cannot be blank")
    @Column(name = "pin_code")
    private Long pin_code;
    @NotNull(message = "Age should be greater than 18")
    @Column(name = "age")
    private int age;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getState_id() {
        return state_id;
    }

    public void setState_id(int state_id) {
        this.state_id = state_id;
    }

    public String getStateNames() {
        return stateNames;
    }

    public void setStateNames(String stateNames) {
        this.stateNames = stateNames;
    }

    public Long getPin_code() {
        return pin_code;
    }

    public void setPin_code(Long pin_code) {
        this.pin_code = pin_code;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Voter{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                ", nationality='" + nationality + '\'' +
                ", state_id=" + state_id +
                ", pin_code=" + pin_code +
                ", age=" + age +
                '}';
    }
}