import javax.swing.JOptionPane;
import java.sql.PreparedStatement;


public class TicketMachine {
    private int price;
    private int change;
    private int balance;

    public int getPrice(){
        return price;
    }

    public int getBalance(){
        return balance;
    }

    public TicketMachine (int ticketCost) {
        price = ticketCost;
        change = 0;
        balance = 0;
    }

    public void insertMoney (int amount){
        balance = balance + amount;
    }

    public static void main(String[] args) {

        String input1 = JOptionPane.showInputDialog(null, " Insert a coin ");
        int ticketCost = Integer.parseInt(input1);
        TicketMachine ticketMachine = new TicketMachine(ticketCost);
        ticketMachine.printTicket();
    }


    public void printTicket(){

        //Simulate the printing of a ticket
        System.out.println("##################");
        System.out.println("# Ticket");
        System.out.println("# " + this.price + " pence.");
        System.out.println("##################");
        System.out.println();
    }
}