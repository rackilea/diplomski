public class Person
    ...
    public Person() { 
        this("unknown", 0); // you can call another constructor 
    }

    public Person(String nm, int ag) {
        name = nm;  
        age = ag;
    }
    ...
}