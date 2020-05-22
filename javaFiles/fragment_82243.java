class Test4 {
    public static void main(String[] args) {
        System.out.println(10); // Inlined constant value here!
    }
}

class Hello {
    final static int x = 10;
    static {
        System.out.println("Hello");                
    }
}