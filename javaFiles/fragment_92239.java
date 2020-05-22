public static void main(String[] args) {
    // pass in the height of the triangles
    // in your example it's 6
    printImage(6);
}

public static void printImage(int height) {
    printTop(height);
    printBottom(height);
}

//also draws the middle part
public static void printBottom(int height) {
    for (int i = height; i > 0; i--) {
        printStar(i);
        printSpace(2 * (height - i));
        printStar(i);
        System.out.println();
    }
}

public static void printTop(int height) {
    for (int i = 1; i < height; i++) {
        printStar(i);
        printSpace(2 * (height - i));
        printStar(i);
        System.out.println();
    }
}

public static void printStar(int stars) {
    for (int i = 0; i < stars; i++) {
        System.out.print("*");
    }
}

public static void printSpace(int spaces) {
    for (int i = 0; i < spaces; i++) {
        System.out.print(" ");
    }
}