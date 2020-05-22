public static void main(String[] args) {
    try {
        Scanner inp = new Scanner(System.in);
        System.out.print("Name?");
        String name = inp.nextLine();
        System.out.print("Number?");
        double num = inp.nextDouble();
        System.out.print("Integer?");
        int num2 = inp.nextInt();

        System.out.println(name);
        System.out.println(num);
        System.out.println(num2);
    } catch (Exception e) {
        System.out.println("Usage error");
    }
}