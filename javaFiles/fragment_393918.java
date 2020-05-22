public static void main(String[] args) {
    Car car1 = new Car();
    Car car2 = new Car();
    // Try with resource automatically closes your Scanner
    try(Scanner scanner = new Scanner(System.in)){
        car1.enterInfo(scanner);
        car2.enterInfo(scanner);
    }
    System.out.println(car1.cost);
    System.out.println(car2.cost);
}