public class Collection {
    // private ArrayList<Dvd> dvds;
    // private int[] array;
    private Dvd dvd1 = null;
    private Dvd dvd2 = null;
    private Dvd dvd3 = null;

    /**
     * Constructor for objects of class Collection
     */
    public Collection() {
        // array = new int[2];
        // dvd1 = dvd1;
        // dvd2 = dvd2;
        // dvd3 = dvd3;
        dvd1 = new Dvd();
        dvd2 = new Dvd();
        dvd3 = new Dvd();
    }

    public static void main(String args[]) {
        // creates an instance of the collection class
        Collection collection = new Collection();
        collection.menu();
    }

    public void displayDvds() {
        float totalPrice = 0;
        totalPrice = dvd1.getDvdPrice() + dvd2.getDvdPrice()
                + dvd3.getDvdPrice();
        double totalRunTime = 0;
        totalRunTime = dvd1.getRunTime() + dvd2.getRunTime()
                + dvd3.getRunTime();

        if (dvd1.getTitle().equalsIgnoreCase("")) {
            System.out
                    .println("Sorry, there were no search results to display.");
        } else {
            System.out.println(" \nDvd Collection:\n DVD1:\n Title: "
                    + dvd1.getTitle() + " \nDirector: " + dvd1.getDirector()
                    + " \nLead Act: " + dvd1.getLead() + " \nRun Time: "
                    + dvd1.getRunTime() + " \nPrice: " + dvd1.getDvdPrice());

            System.out.println(" \nDvd Collection:\n DVD1:\n Title: "
                    + dvd2.getTitle() + " \nDirector: " + dvd2.getDirector()
                    + " \nLead Act: " + dvd2.getLead() + " \nRun Time: "
                    + dvd2.getRunTime() + " \nPrice: " + dvd2.getDvdPrice());

            System.out.println(" \nDvd Collection:\n DVD1:\n Title: "
                    + dvd3.getTitle() + " \nDirector: " + dvd3.getDirector()
                    + " \nLead Act: " + dvd3.getLead() + " \nRun Time: "
                    + dvd3.getRunTime() + " \nPrice: " + dvd3.getDvdPrice());

            System.out.println(" \nCombined cost of combined Dvd's: "
                    + totalPrice);

            System.out.println(" \nCombined Run Time of combined Dvd's: "
                    + totalRunTime);
        }
    }

    public void searchDvd() {
        String temp = ""; // Temporary variable to hold title
        // Assign dvd 3's title to temp

        System.out.println("\nPlease enter Title to search for: ");
        temp = Genio.getString();

        if (temp.equals(dvd1.getTitle())) {
            System.out
                    .println("\nDvd is present in collection at location 1 (Dvd 1 in collection): "
                            + dvd1.getTitle());
        }
        if (temp.equals(dvd2.getTitle())) {
            System.out
                    .println("\nDvd is present in collection at location 2 (Dvd 2 in collection): "
                            + dvd2.getTitle());
        }
        if (temp.equals(dvd3.getTitle())) {
            System.out
                    .println("\nDvd is present in collection at location 3 (Dvd 3 in collection): "
                            + dvd3.getTitle());
        } else
            System.out
                    .println("\nSorry, there were no search results to display.\n ");
    }

    public void menu() {
        // declare the option field
        int option;

        // start do while loop for the menu
        do {
            // display the menu
            System.out.println("1: Add (up to 3) Dvd's to Collection");
            System.out.println("2: Display Dvd Collection");
            System.out.println("3: Search Dvd Collection by collection");
            System.out.println("4: Quit program");

            // prompt user to enter a selection
            System.out.println("Please select an option (1 - 4): ");
            // use genio to get the user input
            option = Genio.getInteger();

            // Option 1 allows user to add up to 3 Dvd's
            if (option == 1) {
                dvd1.getInputs();
                dvd2.getInputs();
                dvd3.getInputs();
            }
            // Option 2 allows user to display Dvd collection
            if (option == 2)
                displayDvds();
            // i Option 3 allows the user to search the Dvd collection by title
            if (option == 3)
                searchDvd();
        }

        // Option 4 will print a message that tells that the program may be
        // exited
        while (option != 4);
        System.out.println("You may now close the program");
    }
}