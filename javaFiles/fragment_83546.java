public class Person{
    private String name;
    private int id;
    private static instanceCounter = 1000;
//always use the constructor to make sure you get mandatory values in your objects 
public Person(String name){
    setName(name);
    this.id = instanceCounter++;

public final void setName(String name)throws IllegalArg....{
    if(name == null || name.isEmpty()){
        throw new IllegalArg..Ex...("Sorry name is not valid");
    }
    this.name = name;
}

 public String getName.....