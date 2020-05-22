//static -> no object creation
public static void a() {
    b(); //call function inside a function
}

//static -> no object creation
//no arguments -> you do not pass any value to your function
public static void b() {
    System.out.println("output something");
}