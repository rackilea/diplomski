private static int x = 0;

public static void incrementActions() {
    x++;
    if(x >= 5) {
        x = 0;
        displayInterstital();
    }
}