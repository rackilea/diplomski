public abstract class Employee{
    private Person person;
    //... 

    Employee(Person p){
       this.person=p;
    }

    public getName(){      // basic example
       person.getName();
    }