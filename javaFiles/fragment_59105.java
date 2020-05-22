public class Gerbil {

private String id;
private String name;
private int[] amountfood;
private int numbergerbils;
private String[] food;

private boolean escape;
private boolean bite;

public Gerbil(String n5, String n6, int[] numOfFood, boolean newEscape, boolean newBite, String[] n2) {

    id = n5;
    name = n6;
    amountfood = numOfFood;
    escape = newEscape;
    bite = newBite;
    food = n2;
}

public Gerbil(String[] typefood) {

    food = typefood;
}

public Gerbil(int[] numOfFood) {
    amountfood = numOfFood;

}

public int[] getAmountFood() {

    return amountfood;
}

public boolean getBite() {

    return bite;
}

public boolean getEscape() {

    return escape;
}

public String getId() {

    return id;
}

public String getName() {
    return name;
}

public void setId(String newId) {
    id = newId;
}

public void setName(String newName) {
    name = newName;
}

public String[] getTypeFood() {

    return food;


}

}



import java.util.Scanner;

public class Gerbilfood {

static int n8;
static int n3;
static String n55;
static String n35;
static String n2;
public static Gerbil[] gerbil;

public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    System.out.println("Please input how many types of food items the  gerbils           eat as an integer");
    String n0 = scanner.nextLine();
    int n1 = Integer.parseInt(n0);

    String[] food = new String[n1];

    for (int i = 0; i < n1; i++) {

        System.out.println("Please enter a food name");

        String n2 = scanner.nextLine();

        food[i] = n2;

        int[] maximum = new int[n1];

        System.out.println("Please enter maximum amount of this food per day");
        String n33 = scanner.nextLine();
        int n3 = Integer.parseInt(n33);
        maximum[i] = n3;
    }

    System.out.println("Please enter in the number of gerbils in the lab");
    String n73 = scanner.nextLine();
    int n4 = Integer.parseInt(n73);
    //gerbil = new Gerbil[n4];

    gerbil = new Gerbil[n4];

    int[] combo = new int[n4];
    String[] ids = new String[n4];
    for (int i = 0; i < n4; i++) {

        //Gerbil g = new Gerbil(n1);
        System.out.println("Please enter in the lab id for one of the gerbils");
        String n5 = scanner.nextLine();
        //g.setId(n5);

        //ids[i] = n5;
        //String[] names = new String[n4];
        System.out.println("Please enter in the name given to gerbil whose lab id you just entered");
        String n6 = scanner.nextLine(); // gerbil name
        //g.setName(n6);

        //String[] amountfood = new String[n1];
        int[] amountfood = new int[n1];

        for (int j = 0; j < n1; j++) {
            System.out.println("how much of " + food[j]
                    + " did this gerbil eat");
            String n8 = scanner.nextLine();
            //amountfood[j = n8;
            amountfood[j] = Integer.parseInt(n8);

        }
        boolean[] bite = new boolean[n4];
        System.out
                .println("Does this Gerbil bite? Enter True or False");
        String n77 = scanner.nextLine();
        if (n77.equalsIgnoreCase("True")) {
            bite[i] = true;
        } else {
            bite[i] = false;
        }

        boolean[] escape = new boolean[n4];
        System.out
                .println("Does this Gerbil escape? Enter True or False");
        String n89 = scanner.nextLine();

        if (n89.equalsIgnoreCase("True")) {
            escape[i] = true;
        } else {
            escape[i] = false;
        }

        gerbil[i] = new Gerbil(n5, n6, amountfood, escape[i], bite[i], food);

    }

    System.out.println("What information would you like to know?");
    String n55 = scanner.nextLine();

    String n33 = "search";
    String n34 = "average";
    String n35 = "restart";
    String n36 = "quit";

    if (n55.equalsIgnoreCase(n34)) {
        System.out.println(averagefood());

    } else {
        if (n55.equalsIgnoreCase(n33)) {

            System.out.println("Please type the lab id of the gerbil you wish to search for");

            String n87 = scanner.nextLine();

            Gerbil g = searchForGerbil(n87);

            Gerbil gerbilattributes = searchForGerbil(n87);

            String gerbid = g.getId();

            String gerbname = g.getName();

            boolean gerbbite = g.getBite();

            boolean gerbescape = g.getEscape();

            for (int i = 0; i < n1; i++) {
                food = g.getTypeFood();
            }


                int[] gerbfoods = g.getAmountFood();

             System.out.print("Lab :"+gerbid + " Name:"+ gerbname + " ("+ ((gerbbite==true)?"will bite":"will not bite")  +  "," + ((gerbescape==true)?"will escape":"will not escape") + ")");
            for (int i = 0; i < n1; i++) {
                System.out.print( " " + food[i] + ":"+ gerbfoods[i]);
            }

        } else {
            if (n55.equalsIgnoreCase(n35)) {

                //GO BACK
            } else {
                if (n55.equalsIgnoreCase(n36)) {

                    System.exit(0);
                } else {
                    System.out.println("ERROR");
                }
            }
        }
    }
}

public static String averagefood() {

    int i = 0;
    Gerbil g = gerbil[i];
    String gid = g.getId();

    String gname = g.getName();
    long percent = Math.round(n8 * 100.0 / n3);

    String everything = gid + " " + gname + " " + percent + "\n";
    for (i = 0; i <= gerbil.length; i++) {

        //turn everything;
    }

    return everything;
}

public static Gerbil searchForGerbil(String n87) {

    for (int i = 0; i < gerbil.length; i++) {
        Gerbil g = gerbil[i];

        if (n87.equals(g.getId())) {
            return gerbil[i];

        }

    // return (new Gerbil[i]);
    }
    return null;

}
}