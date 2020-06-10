package org.launchcode.capstone.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class Customer extends AbstractEntity {

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;

    public Customer(@NotNull String firstName, @NotNull String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
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
}