class A {
    int a;

    A() {
        // Here I want to print B or C
        System.out.println(this.getClass().getSimpleName());
        System.out.println("Enter the value of a");
        a = new Scanner(System.in).nextInt();
    }
}