public static void main(String[] args) {
    Employee emp1;
    Employee emp2;

    emp1 = read_input("first");

    emp2 = read_input("second");

    System.out.println(emp1.toString());
    System.out.println(emp2.toString());

}

public static Employee read_input(String msg) {
    Scanner scan1 = new Scanner(System.in);
    Scanner scan2 = new Scanner(System.in);
    Scanner scan3 = new Scanner(System.in);
    ...