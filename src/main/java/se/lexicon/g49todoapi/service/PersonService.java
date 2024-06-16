package se.lexicon.g49todoapi.service;

import se.lexicon.g49todoapi.domain.entity.Person;
import java.util.List;
import java.util.Optional;

public interface PersonService {
    // Create a new person
    Person create(Person person);

    // Find a person by their ID
    Optional<Person> findById(Long id);

    // Find all persons
    List<Person> findAll();

    // Update an existing person
    Person update(Person person);

    // Delete a person by their ID
    void delete(Long id);
}
