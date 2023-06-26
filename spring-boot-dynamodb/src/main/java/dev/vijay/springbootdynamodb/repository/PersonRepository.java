package dev.vijay.springbootdynamodb.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDeleteExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import dev.vijay.springbootdynamodb.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class PersonRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public Optional<Person> addPerson(Person person){
        Optional<Person> optionalPerson = Optional.empty();
        try {
            dynamoDBMapper.save(person);
            optionalPerson=Optional.ofNullable(person);
        }catch (Exception ex){
            return optionalPerson;
        }
        return optionalPerson;
    }

    public Optional<Person> findPersonById(String personId) {
        Optional<Person> personOptional = Optional.empty();
        try {
            personOptional = Optional.ofNullable(dynamoDBMapper.load(Person.class, personId));
        } catch (Exception ex) {
            return personOptional;
        }
        return personOptional;
    }

    public Optional<String> deletePerson(Person person){
        try {
            dynamoDBMapper.delete(person);
        }
        catch (Exception ex){
            return Optional.ofNullable("Not able to remove person.Got exception:"+ex.getMessage());
        }
        return Optional.ofNullable("Person removed");
    }

    public Optional<String> updatePerson(Person person){
        try {
            dynamoDBMapper.save(person, buildExpression(person));
        }
        catch (Exception ex){
            return Optional.empty();
        }
        return Optional.of("record updated");
    }

    private DynamoDBSaveExpression buildExpression(Person person){
        DynamoDBSaveExpression dynamoDBSaveExpression = new DynamoDBSaveExpression();
        Map<String, ExpectedAttributeValue> expectedMap = new HashMap<>();
        expectedMap.put("personId",new ExpectedAttributeValue(new AttributeValue().withS(person.getPersonId())));
        dynamoDBSaveExpression.setExpected(expectedMap);
        return dynamoDBSaveExpression;
    }
}
