package com.API.API_REST.Person;

import java.util.List; // Importing Service annotation to mark this class as a service
import java.util.Optional; // Importing Lombok for constructor injection

import org.springframework.stereotype.Service; // Ensure correct import for your Person class

import lombok.RequiredArgsConstructor; // Import List for using lists

@Service // This annotation indicates that this class is a service
@RequiredArgsConstructor // Automatically generates a constructor with all final fields
public class PersonService {

    private final PersonRepository personRepo; // Repository instance for accessing database methods

    // Method to create and save a new person record
    public Person createPerson(Person person) {
        return personRepo.save(person); // Saves the person entity and returns the saved entity
    }

    // Method to fetch all persons
    public List<Person> getAllPersons() {
        return personRepo.findAll(); // Returns a list of all persons in the database
    }

    // Method to get a person by ID
    public Optional<Person> getPersonById(Integer id) {
        return personRepo.findById(id); // Finds a person by ID and returns an Optional
    }

    // Method to update existing person
    public Person updatePerson(Integer id, Person personDetails) {
        return personRepo.findById(id)
            .map(person -> {
                person.setFirstname(personDetails.getFirstname()); // Update firstname
                person.setLastname(personDetails.getLastname()); // Update lastname
                person.setEmail(personDetails.getEmail()); // Update email
                return personRepo.save(person); // Save the updated person
            })
            .orElseGet(() -> {
                personDetails.setId(id); // If not found, set the ID for a new instance
                return personRepo.save(personDetails); // Save new person
            });
    }

    // Method to delete a person by ID
    public void deletePerson(Integer id) {
        personRepo.deleteById(id); // Deletes the person by ID
    }
}

