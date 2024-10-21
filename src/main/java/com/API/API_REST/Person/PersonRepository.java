package com.API.API_REST.Person;

import org.springframework.data.jpa.repository.JpaRepository; // Importing JpaRepository for basic CRUD operations
import org.springframework.stereotype.Repository; // Marking this interface as a Spring repository

@Repository // Marks this interface as a repository for Spring's component scanning
public interface PersonRepository extends JpaRepository<Person, Integer> {
    // JpaRepository will provide CRUD operations automatically
    // Additional custom query methods can be declared here if needed
}
