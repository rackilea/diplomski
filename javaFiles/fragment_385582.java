public static void main(String[] args) {

    boolean cond = false;
    Activity a = new Activity();
    Test t = new Test();
    t.interInstance=a; //Add this line to your code

    if (cond)
        System.out.println(a.interfaceMethod("John"));
    else
        t.update(); //interInstance mustn't be null at this point
        System.out.println(t.interInstance.interfaceMethod("Doe"));
}