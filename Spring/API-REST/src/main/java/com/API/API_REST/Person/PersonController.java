package com.API.API_REST.Person; // Package declaration

import java.util.List; // Import for dependency injection
import java.util.Optional; // Import for building HTTP responses

import org.springframework.http.ResponseEntity; // Import for RESTful web service annotations
import org.springframework.web.bind.annotation.DeleteMapping; // Import for constructor injection
import org.springframework.web.bind.annotation.GetMapping; // Import your Person class
import org.springframework.web.bind.annotation.PathVariable; // Import List for returning lists of persons
import org.springframework.web.bind.annotation.PostMapping; // Import Optional for handling optional person retrieval
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController // Mark this class as a REST controller
@RequestMapping("/api/person") // Define the base URL for all methods in this controller
@RequiredArgsConstructor // Automatically generate a constructor with required parameters
public class PersonController {

    private final PersonService personService; // Service instance for handling person-related operations

    // Create a new person entry in the database
    @PostMapping // Handle POST requests for creating a person
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        Person savedPerson = personService.createPerson(person); // Call the service to save the person
        return ResponseEntity.ok(savedPerson); // Return the saved person wrapped in a ResponseEntity
    }

    // Retrieve all persons from the database
    @GetMapping // Handle GET requests for retrieving all persons
    public ResponseEntity<List<Person>> getAllPersons() {
        List<Person> persons = personService.getAllPersons(); // Call the service to fetch all persons
        return ResponseEntity.ok(persons); // Return the list of persons
    }

    // Retrieve a person by their ID
    @GetMapping("/{id}") // Handle GET requests for retrieving a specific person by ID
    public ResponseEntity<Person> getPersonById(@PathVariable Integer id) {
        Optional<Person> person = personService.getPersonById(id); // Call the service to fetch the person by ID
        return person.map(ResponseEntity::ok) // If found, return the person
            .orElse(ResponseEntity.notFound().build()); // If not found, return a 404 Not Found response
    }

    // Update an existing person entry
    @PutMapping("/{id}") // Handle PUT requests for updating a specific person
    public ResponseEntity<Person> updatePerson(@PathVariable Integer id, @RequestBody Person personDetails) {
        Person updatedPerson = personService.updatePerson(id, personDetails); // Call the service to update the person's details
        return ResponseEntity.ok(updatedPerson); // Return the updated person
    }

    // Delete a person by their ID
    @DeleteMapping("/{id}") // Handle DELETE requests for removing a specific person
    public ResponseEntity<Void> deletePerson(@PathVariable Integer id) {
        personService.deletePerson(id); // Call the service to delete the person by ID
        return ResponseEntity.noContent().build(); // Return a 204 No Content response indicating successful deletion
    }
}
