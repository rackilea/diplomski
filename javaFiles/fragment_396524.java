public static double inputSide () {
    Scanner in = new Scanner(System.in);
    double side = -1;
    do {
        try {
            System.out.println("Enter a side length (in units):");
            side = in.nextDouble();
        }
        catch(InputMismatchException e){
            System.out.println("Must input number");
            //this line frees the buffer
            in.next();
        }
    } while (side < 0);
    return side;
}