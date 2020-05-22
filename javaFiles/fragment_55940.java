public static void Main() {
    MyClass obj1 = new MyClass(3);
    MyClass obj2 = new MyClass(4);

    moveNumber(obj1, obj2);

    System.out.println("obj1 number ===> " + obj1.getNumber());   // prints 3
    System.out.println("obj2 number ===> " + obj2.getNumber());   // prints 3
}