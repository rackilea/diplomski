public class Transaction {
    private Date timestamp;
    private byte type; // I prefer to use an enum here...
    private int amount;
    .... // next add the getter and setter for each attribute
}