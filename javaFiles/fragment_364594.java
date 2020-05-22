public class Customer {
    String name;
    int PESEL;
    Room room;

    // constructor for Customer with a room argument
    Customer(String name,int PESEL, Room room) {
        this.name=name;
        this.PESEL=PESEL;
        this.room = room;
        }
    }

    // constructor for Customer with a default room, though impractical :)
    Customer(String name,int PESEL) {
        this.name=name;
        this.PESEL=PESEL;
        this.room = new Room(0);
    }
}