package org.launchcode.capstone.models;

import javax.persistence.GeneratedValue;
import javax.persistence.MappedSuperclass;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public abstract class AbstractEntity {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message="Required field")
    @Size(min=3, max=75, message="Must be between 3 and 75 characters")
    private String firstName;

    @NotBlank(message="Required field")
    @Size(min=3, max=75, message="Must be between 3 and 75 characters")
    private String lastName;

}
