public class Person {

    public Person (String first, String last, String email) {
        // You'd fill in code here for handling the variables
    }

    // ...
}

public class Customer extends Person {

    public Customer (String first, String last, String email, String custNo) {
        super(first, last, email);
        // You'd fill in code here for handling the variables
    }

    // ...
}

public class Employee extends Person {

    public Employee (int social) {
        super(first, last, email);
        // You'd fill in code here for handling the variables
    }

    // ...
}