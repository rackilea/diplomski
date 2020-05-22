public static void main(String[] args) {

    Scanner kp = new Scanner(System.in);

    final int size = 15;
    char q = 'y';
    boolean flag = false;

    Shifter test = new Shifter(size);
    Scanner input = new Scanner(System.in);

    for(;;) {
        test.display();
        System.out.println();
        System.out.print("Shift how many positions? ");

        String value = input.next();
        if (value.equals("q")) break;
        int value1 = Integer.parseInt(value);
        test.shift(value1);
    }
}