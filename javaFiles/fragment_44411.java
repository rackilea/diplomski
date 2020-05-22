public class Reservation {

    private String firstName;
    private String lastName;
    private float price;
    private int seatNumber;
    private char seatLetter;

    // Constructor. Aligns values to the fields.
    public Reservation(String firstName, String lastName,
            float price, int seatNumber, char seatLetter){
        this.firstName = firstName;
        this.lastName = lastName;
        this.price = price;
        this.seatNumber = seatNumber;
        this.seatLetter = seatLetter;
    }

    // Returns a string with the values of the fields.
    public String toString(){
        return firstName + " " + lastName
            + "\nPrice: " + price
            + "\nSeat: " + seatLetter + seatNumber;
    }

    // Returns the value of seatLetter
    public char getSeatLetter() {
        return seatLetter;
    }
    // Returns the value of seatNumber
    public int getSeatNumber() {
        return seatNumber;
    }
}