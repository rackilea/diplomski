private static String fileName = null;
private static int imageHeight = 0;
private static int imageWidth = 0;
public static int MAXSIDE = 100;
private static String[][] buffer = new String[MAXSIDE][MAXSIDE];
public static Scanner scan = new Scanner(System.in);

public static void main(String args[]) throws FileNotFoundException {
    boolean a = askPermission();
    while (a == true) {
        getParameters();
        getImage();
        printImage();
        a = askPermission();
    }
    System.out.println("No more? All done then!");
}

public static boolean askPermission() {
    System.out.println("Would you like to tile an image? Enter either y or n ------> ");
    String a = scan.next();
    if ("y".equals(a)) {

        return true;
    } else {

        return false;
    }

}

static void getParameters() {
    System.out.println("Please type the name of the file you would like to tile: ");
    fileName = scan.next();
    System.out.println("Getting image...");
}

public static void getImage() throws FileNotFoundException {
    Scanner input = new Scanner(new File(fileName));
    imageHeight = input.nextInt();
    imageWidth = input.nextInt();
    input.useDelimiter("(?<=.)");
    for (int i = 0; i < imageHeight; i++) {

        for (int j = 0; j < imageWidth; j++) {
            buffer[i][j] = input.next();
        }
    }
    input.close();

}

public static void printImage() {
    for (int i = 0; i < imageHeight; i++) {
        for (int j = 0; j < imageWidth; j++) {
            System.out.print(buffer[i][j]);
        }

    }
    System.out.println(); 
}