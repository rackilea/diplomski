package playground.space;

public class Fourlegs {
String room;
Fourlegs cat; // global variable here

public static void main(String[] args) {
    Fourlegs program = new Fourlegs();

    program.start();
}

public void start() {
    Fourlegs cat = new Fourlegs();
    cat.room = "office";
    Fourlegs dog = new Fourlegs();
    dog.room = "office";
    dog.cat = cat; // global variable set here

    //dog moves to the carpark, and the cat follows the dog
    dog.cat = new Fourlegs();
    dog.move("carpark");
}

public void move(String i) {
    this.room = i;

    cat.room = this.room; //the cat's room will be the same as the dog's room.
    System.out.println("the cat is in the " + cat.room);
}


}