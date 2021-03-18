package com.example.demo.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Employee implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Long id;
    private String name;
    private String email;
    private String imageUrl;
    private String jobTitle;
    @Column(nullable = false,updatable = false)
    private String employeeCode;
    private String phone;

    public Employee() {
    }

    public Employee(String name, String email, String imageUrl, String jobTitle, String employeeCode, String phone) {
        this.name = name;
        this.email = email;
        this.imageUrl = imageUrl;
        this.jobTitle = jobTitle;
        this.employeeCode = employeeCode;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", employeeCode='" + employeeCode + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
