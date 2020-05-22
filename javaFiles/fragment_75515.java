public class JavaVision {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static int x;
    static String name[] = new String[48];

    public static void main(String[] args) throws IOException {

        int choice;

        do {
            System.out.println("     ");
            System.out.println("Java TV Program Menu");
            System.out.println("----------------------------");
            System.out.println("What would you like to do?");
            System.out.println("1. Add a TV Show");
            System.out.println("2. Modify a TV Show");
            System.out.println("3. Delete a TV Show");
            System.out.println("4. Sort TV Shows");
            System.out.println("5. Show All TV Shows");
            System.out.println("6. Exit");

            choice = Integer.valueOf(in.readLine()).intValue();

            if(choice ==1) {
                enterTVshow();
            }
            if(choice ==2) {
                modTVshow();
            }
            if(choice ==3) {
                deleteTVshow();
            }
            if (choice ==4) {
                sortArray(name);


            }

            if(choice ==5) {
                System.out.println(Arrays.toString(name));
            }

        }while (choice !=6);
    }

    private static void deleteTVshow() throws IOException {
        String deleteTVshow;
        int flag = 0;
        int i;
        boolean found = false;

        System.out.print("Which TV Show do you want to delete?");
        deleteTVshow = in.readLine();

        for(i = 0; i<=(x-1); i++) {
            if(deleteTVshow.compareTo(name[i]) == 0) {
                flag = x;
                found = true;
            }
        }

        if (found == false) {
            System.out.println("There is no TV Show by that name.");
        }
        else {
            for(i = flag; i <=(x-2); x++) {
                name[i] = name[i+1];
            }
            x = x -1;
            System.out.print("Type 'go back' to go back to the menu");
        }while ((in.readLine().compareTo("go back")) !=0);

    }

    private static void modTVshow() throws IOException {
        String modTVshow;
        int flag = 0;
        int i;
        boolean found = false;

        System.out.print("What is the TV Show you wish to modify?");
        modTVshow = in.readLine();

        for(i = 0; i<= (x-1); i++) {
            if(modTVshow.compareTo(name[i]) == 0) {
                flag = i;
                found = true;
            }
        }
        if (found == false) {
            System.out.print("There is no TV show by that name.");
        }
        else {
            System.out.print("Enter new Name: ");
            name[flag] = in.readLine();
            System.out.print("Type 'go back' to go back to the menu");
        }while ((in.readLine().compareTo("go back")) !=0);
    }

    private static void enterTVshow() throws IOException {
        System.out.println();
        x = 0;

        while(name[x]!=null){

            x++;
        }

        do {
            System.out.print("Enter TV Show Name:");
            name[x] = in.readLine();
            x++;
            System.out.print("Adding Show.....");
            System.out.println("     ");
            System.out.print("Type 'go back' to go back to the menu ");
            sortArray(name);
        }while((in.readLine().compareTo("go back")) !=0);

    }

    public static void sortArray(String [] myArray){

        Arrays.sort(myArray, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1 == null && o2 == null) {
                    return 0;
                }
                if (o1 == null) {
                    return 1;
                }
                if (o2 == null) {
                    return -1;
                }
                return o1.compareTo(o2);
            }});
    }

}