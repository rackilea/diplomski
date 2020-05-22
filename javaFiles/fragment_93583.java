public static void main(String[] args) {
    Integer x1 = null, y1 = null, x2 = null, y2 = null, x3 = null, y3 = null, x4 = null, y4 = null;
    System.out.println("Point 1 x y: ");
    Scanner input = new Scanner(System.in);
    x1 = validInputX(x1, input);
    y1 = validInputY(y1, input);
}

public static int validInputX(Integer x, Scanner input) {

    while (x == null) {
        try {
            x = input.nextInt();
        } catch (InputMismatchException ex) {
            input = new Scanner(System.in);
            System.out.println("please provide valid input");
        }
    }
    return x;
}

public static int validInputY(Integer y, Scanner input) {        
    while (y == null) {
        try {
            y = input.nextInt();
        } catch (InputMismatchException ex) {
            input = new Scanner(System.in);
            System.out.println("please provide valid input");
        }
    }
    return y;
}