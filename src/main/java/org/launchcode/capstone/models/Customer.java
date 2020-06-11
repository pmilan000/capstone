package org.launchcode.capstone.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
public class Customer extends AbstractEntity {

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

    @OneToOne(cascade = CascadeType.ALL)
    @Valid
    @NotNull
    private CustomerDetails customerDetails;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Customer(){}

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
}