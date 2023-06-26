package dev.vijay.springbootdynamodb.controller;

import dev.vijay.springbootdynamodb.entity.Person;
import dev.vijay.springbootdynamodb.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;

import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/{personId")
    public ResponseEntity<Person> getPersonById(@PathVariable(name = "personId") String personId) {

        Optional<Person> optionalPerson = personRepository.findPersonById(personId);

        if (optionalPerson.isPresent()) {
            return ResponseEntity.ok(optionalPerson.get());
        } else {
            return ResponseEntity.badRequest().body(new Person());
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deletePerson(@RequestBody Person person) {
        Optional<String> optionalDelete = personRepository.deletePerson(person);
        if (optionalDelete.isPresent()) {
            return ResponseEntity.ok(optionalDelete.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/addPerson")
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        Optional<Person> optionalPerson = personRepository.addPerson(person);
        if (optionalPerson.isPresent()) {
            return ResponseEntity.ok(optionalPerson.get());
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    public ResponseEntity<String> updatePerson(@RequestBody Person person){
        Optional<String> updatePerson=personRepository.updatePerson(person);

        if(updatePerson.isPresent()){
            return ResponseEntity.ok(updatePerson.get());
        }
        else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
