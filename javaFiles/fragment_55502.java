public class Ticket {
    private String name;
    private String symbol;
    private String title;
    private String summary;
    private String question;
    private String answer;

    public Ticket(String name, String symbol, String title, String summary, String question, String answer) {
        // set all the variables with the arguments passed in. E.g.
        this.name = name;
    }

    // create getters and setters if you wish. If you need to use symbol, you will
    // need to create a getter for that, e.g.:

    public String getSymbol() {
        return symbol;
    }

    // You can override the default toString() method to get your ticket, 
    // or you can just call this makeTicket() instead.
    @Override
    public String toString() {
        String z = "\r";
        String header = z + z + "Cog241/CSC241 Fall 2014" + z + "Ticket To Demo" + z 
           + z;
        return header + z + "Name:  " + name + z + "Assignment:  " + symbol + " - " 
            + title + "\r" + "Summary..." + "\r" + summary + z + z + "Question..." 
            + z + question + z + z + "Answer..." + answer;
    }
}