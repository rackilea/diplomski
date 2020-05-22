public class Primitive_prac {

   public static void main(String[] args) {
    // TODO code application logic here

    Animal obj1 = new Bird();
    Bird obj2 = new Bitd();
    obj1.move(); //valid, since obj1 is declared `Animal`
    obj1.fly(); // invalid, since obj1 could be any animal and not all animals implement fly();
    obj2.move(); // Valid, all birds are animals and all animals (as defined here) move, therefore birds can move
    obj2.fly(); //valid, obj2 can only be a bird or a subclass, and all such objects can fly()

    System.out.println("ojb1 is instance of Animal: " + (obj1 instanceof Animal));
    System.out.println("ojb1 is instance of Bird: " + (obj1 instanceof Bird));
    System.out.println("ojb1 is instance of Flying: " + (obj1 instanceof Flying));

    System.out.println();

    System.out.println("ojb2 is instance of Bird: " + (obj2 instanceof Animal));
    System.out.println("ojb2 is instance of Animal: " + (obj2 instanceof Bird));
    System.out.println("ojb2 is instance of Flying: " + (obj2 instanceof Flying));

    }
}

class Animal{ void move("Moving...") {} }
interface Flying{ void fly(); }
class Child extends Parent implements Interface1{
    void fly() {System.out.println("flap flap");}
}