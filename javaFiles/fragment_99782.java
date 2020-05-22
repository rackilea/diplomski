package com.example.vaadin.ex_formatinteger;

import java.time.LocalDate;
import java.time.ZoneId;

/**
 * Created by Basil Bourque on 2017-03-31.
 */
public class Person {

    private String honorific ;
    private String name;
    private Integer yearOfBirth;

    // Constructor
    public Person ( String honorificArg , String nameArg , Integer yearOfBirthArg ) {
        this.honorific = honorificArg;
        this.name = nameArg;
        this.yearOfBirth = yearOfBirthArg;
    }

    public String getHonorific ( ) {
        return honorific;
    }

    public void setHonorific ( String honorific ) {
        this.honorific = honorific;
    }

    // name property
    public String getName ( ) {
        return name;
    }

    public void setName ( String nameArg ) {
        this.name = nameArg;
    }

    // yearOfBirth property
    public Integer getYearOfBirth ( ) {
        return yearOfBirth;
    }

    public void setYearOfBirth ( Integer yearOfBirth ) {
        this.yearOfBirth = yearOfBirth;
    }

    // age property. Calculated, so getter only, no setter.
    public Integer getAge ( ) {
        int age = ( LocalDate.now ( ZoneId.systemDefault ( ) )
                             .getYear ( ) - this.yearOfBirth );
        return age;
    }

    @Override
    public String toString ( ) {
        return "Person{ " +
                "honorific='" + this.getHonorific () + '\'' +
                ", name='" + this.getName ()  +
                ", yearOfBirth=" + this.yearOfBirth +
                ", age=" + this.getAge () +
                " }";
    }
}