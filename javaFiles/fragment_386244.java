public static String divide(int a, int b){
    int x = 0;
    try{
        x = divide0(a, b);
    }
    catch(ArithmeticException e){
        System.out.println("Caught Arithmetic Exception!");
    }
    catch(Throwable t){
        System.out.println("Caught a Different Exception!");
    }
    return "Result: "+x;
}

static int divide0(int a, int b) {
    return a/b;
}

@Test(expected = ArithmeticException.class)
public void testDivideByZero() {
    divide0(1, 0);
}