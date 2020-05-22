class Example {
    int i = 8;
    static void test(Example l, Example m) {
        if(l.i == m.i)
           System.out.println("Hello!");
    }
}

class Main {
    public static void main(String[] args) {
        Example l = new Example();
        Example m = new Example();
        Example.test(l, m);
    }
}