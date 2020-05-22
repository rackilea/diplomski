class TestClass {

    static double g = 0;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double b = 0;
        while (b != -1) {
            b = scan.nextDouble() //you need to change nextInt() to nextDouble()
            add(b);
        }
        System.out.println(g);
    }

    public static void add(double b) {
        g += b;    //g refers to the variable about the main method
    }
}