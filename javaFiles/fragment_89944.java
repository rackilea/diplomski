public static void main(String[] s) {
    int a = 0;
    Scanner scan = new Scanner(System.in);
    System.out.println("Input value of a: " + (a = new Main().getVal()) + " !");
    System.out.println("A = " + a);
}
public int getVal(){
    System.out.println("getVal called first.");
    return 5;
}