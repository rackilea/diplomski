public class Classes {
    private static final String[][] CLASSES = { { "Maths", "info" }, { "History", "info" }, { "Biology", "info" } };

    public static void main(String[] args) {
        boolean found = false;
        String name;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("Please enter the name of your course to display it's information");
            name = input.nextLine();
            for (int i = 0; i < CLASSES.length; i++) {
                if (name.equals(CLASSES[i][0])) {
                    found = true;
                    System.out.println("Course info: " + CLASSES[i][0]);
                    System.out.println(CLASSES[i][1]);
//                  System.out.println(CLASSES[i][2]); //My CLASSES array, does not have 3 columns
                    break;// exit for loop
                }
            }
            if (!found)
                System.out.println("Wrong course id");
        } while (!found);
        input.close();
        System.out.println("This is the end of the program!");
    }
}