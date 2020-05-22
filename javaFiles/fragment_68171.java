package com.test.pojoproject;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PersonDataSet {

    public Iterator<Person> itr;

    public List<Person> getPersons() {
        List<Person> persons = new ArrayList<Person>();

        for (int i = 0; i < 30; i++) {
            Person  person = new Person();
            person.setId(i+1);
            person.setName("person " + (i+1));
            person.setAddress("address " + (i+1));
            persons.add(person);
        }

        return persons;
    }

    public void open(Object obj, Map<String,Object> map) {
    }

    public Object next() {
        if (itr == null)
            itr = getPersons().iterator();
        if (itr.hasNext())
            return itr.next();
        return null;
    }

    public void close() {
    }

}