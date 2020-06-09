package org.launchcode.capstone.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Customer extends AbstractEntity {

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String serviceAddress;
    @NotNull
    private Integer phone;
    @NotNull
    private String email;

    public Customer(String firstName, String lastName, String serviceAddress, Integer phone, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.serviceAddress = serviceAddress;
        this.phone = phone;
        this.email = email;
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

    public String getServiceAddress() {
        return serviceAddress;
    }
    public void setServiceAddress(String serviceAddress) {
        this.serviceAddress = serviceAddress;
    }

    public Integer getPhone() {
        return phone;
    }
    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
