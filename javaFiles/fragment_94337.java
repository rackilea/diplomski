abstract class Person{
       protected String name;
       protected String surname;
       public String getFullName(){return name+" "+surname;}
    }
    public class Employee extends Person{ 
       public Employee(String name, String surname){
          this.name=name; this.surname=surname;
       }
    }
    public class Mister extends Person{
       public Employee(String name, String surname){
          this.name=name; this.surname=surname;
       }
       public String getFullName(){return "Mr. "+name+" "+surname;}
    }