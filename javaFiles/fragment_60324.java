public static void main(String[] args) {

    int x, y;
    x = 13;
    y = 5;

    Calculation add = new Addition(x, y);
    System.out.println(add.calculate());
}