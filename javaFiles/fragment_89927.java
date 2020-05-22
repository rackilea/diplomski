import java.util.ArrayList;

public class Party2
{
 // instance variables that will hold your data
 // private indicates they belong to this class exclusively
 private int maxGuests;
 private String host;
 private ArrayList<String> guests;
 private ArrayList<String> extraGuest;

 //Constructor
 public Party2(int maxGuests, String host)
 {
    System.out.println("Maximum number of guests: " + maxGuests + ".  Guest list for " + host + "'s party. \n");
    this.guests = new ArrayList<String>();
    this.extraGuest = new ArrayList<String>();
    this.maxGuests = maxGuests;
    this.host = host;
 }

 //getter
 // define type of data to be returned
 public String getHost()
 {
    System.out.println("Setting host to: " + host);
    return host;
 }

 //setter
 // setters have type void b/c they return nothing
 public void setHost(String host)
 {
    System.out.println("Setting host to: " + host);
    this.host = host;
 }

 //*************************************
 //Method to add to guest list
 public void addGuest(String guest)
 {

    if (guests.size() < maxGuests)
    {
        System.out.println("Guest: " + guest + "\n");
        this.guests.add(guest);
    }

    else
    {
        extraGuest.add(guest);
        System.out.println("     Guest cannot be added. Guest list is full. \n");
    }//end if

 }//end method

 //*************************************
 //Method to print party
 public void printParty()
 {
      System.out.println("****************************************************\n");
    System.out.println("Guest list for " +
    this.host + "'s party is: \n\n" +
    this.guests + ".\n");

    System.out.println(extraGuest+"weren't added to the list because the guest list is full");

 } // end Print Party method

}//end class party