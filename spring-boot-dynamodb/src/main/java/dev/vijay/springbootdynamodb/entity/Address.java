package dev.vijay.springbootdynamodb.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

import java.io.Serializable;

@DynamoDBDocument
public class Address implements Serializable {
    @DynamoDBAttribute
    private String road;
    @DynamoDBAttribute
    private int pinCode;
    @DynamoDBAttribute
    private String city;
}
