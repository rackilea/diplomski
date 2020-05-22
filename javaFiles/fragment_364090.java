import java.util.ArrayList;

public class Main {
    private ArrayList<List> userlists;

    public Main() {
        userlists = new ArrayList<List>();
        System.out.print('\f');
        System.out.println("this text will show.");
        newlist("listname");
    }

    public void newlist(String listname) {
        System.out.println("this text will show too!");
        List userlist = new List(listname); // terminal does not show lines
                                            // printed by constructor of List?
        userlists.add(userlist);
        userlist.printSomeText(); // second attempt to print a line, does not
                                    // show in terminal.
    }

    public static void main(String ... args){
        new Main();
    }
}

class List {
    private String listname;

    public List(String ln) {
        listname = ln;
        System.out.println("this text does not show.");
    }

    public void printSomeText() {
        System.out.println("this text neither.");
    }
}