package problem94_phonebook;
import java.util.ArrayList;
import Phonebook;


public class Person {

    private String Name;
    private String Numb;
    private ArrayList<Phonebook> phonebook; // updated

    public Person(String name, String numb){
        this.Name = name;
        this.Numb = numb;
        this.phonebook= new ArrayList<Phonebook>();// updated
    }

    public String getName() {
        return Name;
    }

    public String getNumber() {
        return Numb;
    }

    public String toString(){
        return this.Name +"  " +"nummber:  " + this.Numb;   
    }

    public void changeNumber(String newNumber){
        this.Numb = newNumber;
    }

    public void add(Person personToBeAdded){ // changed
        boolean isPresent = false;
        // check if person to be added is already in the phonebook to avoid duplicates
        for (Person person:this.phonebook){
            if (person.getName().equals(personToBeAdded.getName()) && person.getNumber().equals(personToBeAdded.getNumber())){
                isPresent = true;
                break;
            }    
        }
        if (!isPresent){
            this.phonebook.add(personToBeAdded);
        }
    }

    public void printAll(){
      for(Person person : this.phonebook){
        System.out.println(person.toString());
      }
    }
}