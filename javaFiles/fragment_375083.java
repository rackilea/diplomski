package de.scrum_master.app;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class MyEntity {
    @Enumerated(EnumType.STRING) // I want this to compile ok
    protected MyEnumType myEnumFieldA;

    @Enumerated(EnumType.ORDINAL) // I want this to throw a warning
    protected MyEnumType myEnumFieldB;

    public static void main(String[] args) {
        MyEntity myEntity = new MyEntity();
        myEntity.myEnumFieldA = new MyEnumType();
        System.out.println(myEntity.myEnumFieldB);
    }
}