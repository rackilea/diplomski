public class HelloWorld {

    public static void main(String []args) {
        HelloWorld app = new HelloWorld();

        int n = 100000;

        long startTime = System.nanoTime();
        app.doEqualsNull(n);
        long endTime = System.nanoTime();
        System.out.println("doEqualsNull (ns): " + (endTime - startTime)) ; 

        startTime = System.nanoTime();
        app.doEqualsThis(n);
        endTime = System.nanoTime();
        System.out.println("doEqualsThis (ns): " + (endTime - startTime)) ;

        startTime = System.nanoTime();
        app.doEqualsSameInt(n);
        endTime = System.nanoTime();
        System.out.println("doEqualsSameInt (ns): " + (endTime - startTime)) ;

        startTime = System.nanoTime();
        app.doEqualsDifferentInt(n);
        endTime = System.nanoTime();
        System.out.println("doEqualsDifferentInt (ns): " + (endTime - startTime)) ;
    }

    public void doEqualsNull(int n) {
        for (int i = 0 ; i < n ; i++) {
            this.equals(null);
        }
    }

    public void doEqualsThis(int n) {
        for (int i = 0 ; i < n ; i++) {
            this.equals(this);
        }
    }

    public boolean equals(Object obj){
        return this == obj; 
    }

    public void doEqualsSameInt(int n) {
        for (int i = 0 ; i < n ; i++) {
            this.equalsInt(5);
        }
    }

    public void doEqualsDifferentInt(int n) {
        for (int i = 0 ; i < n ; i++) {
            this.equalsInt(50);
        }
    }

    public boolean equalsInt(int other){
        return 5 == other; 
    }
}