public static void main(String[] args) {
    String name = null;
    double num = 0;
    int num2 = 0;
    try {
        Scanner inp = new Scanner(System.in);
        System.out.print("Name?");
        name = inp.nextLine();
        System.out.print("Number?");
        num = inp.nextDouble();
        System.out.print("Integer?");
        num2 = inp.nextInt();
    } catch (Exception e) {
        System.out.println("Usage error");
    }
    System.out.println(name);
    System.out.println(num);
    System.out.println(num2);
}