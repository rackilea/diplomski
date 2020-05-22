public class Main {
    public static void main(String[] args) throws IOException {
        Scanner inp = new Scanner(System.in);
        int someValue = inp.nextInt();
        MyInteger myInt = new MyInteger(someValue);
        System.out.println("Testing instance method:");
        System.out.println(myInt.isPrime());
        System.out.println("Testing static method:");
        System.out.println(MyInteger.isPrime(myInt));
    }
}

class MyInteger {
    private int value;

    public MyInteger(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }
    public boolean isPrime() {
        int sqrt = (int) Math.sqrt((double)value);
        for(int i = 2; i <= sqrt; i++) {
            if (value % i == 0) return false;
        }
        return true;
    }

    public static boolean isPrime(MyInteger myInt) {
        return myInt.isPrime();
    }
}