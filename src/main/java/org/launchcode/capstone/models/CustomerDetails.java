package org.launchcode.capstone.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class CustomerDetails extends AbstractEntity {

    @NotNull
    private String serviceAddress;
    @NotNull
    private String phone;
    @NotNull
    private String email;

    public CustomerDetails(String serviceAddress, String phone, String email) {
        this.serviceAddress = serviceAddress;
        this.phone = phone;
        this.email = email;
    }

    public CustomerDetails() {}

    public String getServiceAddress() {
        return serviceAddress;
    }
    public void setServiceAddress(String serviceAddress) {
        this.serviceAddress = serviceAddress;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}


