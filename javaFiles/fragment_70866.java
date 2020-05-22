package com.test.serialize;

import java.io.Serializable;

public class MyObject implements Serializable{

    /**
     * Added serial version Id of old class, created before adding new fields
     */
    private static final long serialVersionUID = 5512234731442983181L;


public MyObject() {
    System.out.println("Constructor");
}

String name;


public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}


String names ="Altered after change!";

public String getNames() {
    return names;
}

public void setNames(String names) {
    System.out.println("Setting names");
    this.names = names;
}

@Override
public String toString() {
    return "MyObject [name=" + name + ", names=" + names + "]";
}

}