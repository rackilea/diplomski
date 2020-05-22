import java.util.ArrayList;

public class Tester{
public static void main(String[] args){
    Persons philip = new Persons(1, "Philip", "philipemail@email.com");
    Persons steve = new Persons(2, "Steve", "steveemail@email.com");
    Persons samatha = new Persons(3, "Samatha", "samathaemail.com");

    ArrayList<Persons> list = new ArrayList<>();
    list.add(philip);
    list.add(steve);
    list.add(samatha);

    for(int i=0;i<3;i++){
        System.out.println("ID number: " + list.get(i).getId());
        System.out.println("Name: " + list.get(i).getName());
        System.out.println("Email: " + list.get(i).getEmail());
    }
}
}