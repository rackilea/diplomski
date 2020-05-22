class Foo {
    private static Car[] cars;
    public static void main(String[] args) {
         cars = new Car[5];
         cars[0] = new Car("BMW", 318, "SomeText");
         carDetails(0);
    }
    private static void carDetails( int index ) {
       System.out.println( cars[index].getName() + " "
                    + cars[index].getModel() + " "
                    + cars[index].getSomeText());
    }
}