package net.tzolov.avro.extend;

import net.tzolov.avro.extend.Person;

public aspect PersonAspect {

    public String Person.getCompleteName() {        
        return this.getFirstName() + " " + this.getLastName();
    }
}