package com.API.API_REST.Person;

import jakarta.persistence.Basic; // Importing Basic annotation for JPA purposes
import jakarta.persistence.Entity; // Importing Entity annotation to define this class as a JPA entity
import jakarta.persistence.GeneratedValue; // Importing GeneratedValue for automatically generating IDs
import jakarta.persistence.Id; // Importing Id annotation to denote primary key
import lombok.AllArgsConstructor; // Importing Lombok annotation for all-args constructor
import lombok.Data; // Importing Lombok annotation for generating getters, setters, equals, hashCode, and toString
import lombok.NoArgsConstructor; // Importing Lombok annotation for no-args constructor

@Data
@AllArgsConstructor // Generates a constructor with parameters for all fields
@NoArgsConstructor // Generates a no-args constructor
@Entity // Marks this class as a JPA entity
public class Person {
    @Id // Primary key annotation
    @GeneratedValue // Specifies that the ID should be generated automatically
    private Integer id; // Unique identifier for the person

    @Basic // Indicates that this field is a basic attribute
    private String firstname; // First name of the person
    private String lastname; // Last name of the person
    private String email; // Email address of the person
}
