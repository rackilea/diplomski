public class Foo {
    private static Foo instance;
    private String someString;
    private int someNum;

    private Foo() {
        someString = "a";
        someNum = 1;
    }

    public synchronized static Foo getInstance(){
        if(instance == null) {
            instance = new Foo();
        }
        return instance;
    }

    public synchronized void setSomeString(String someString) {
        this.someString = someString;
    }

    public synchronized void setSomeNum(int someNum) {
        this.someNum = someNum;
    }

    @Override
    public synchronized String toString() {
        return "Foo{" +
                "someString='" + someString + '\'' +
                ", someNum=" + someNum +
                '}';
    }
}

public class Baz implements Runnable {
    public void run() {
        Foo foo = Foo.getInstance();
        while(true) {
            System.out.println("Baz: " + foo);
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


public class Bar implements Runnable {
    public void run() {
        Foo foo = Foo.getInstance();
        foo.setSomeNum(2);
        foo.setSomeString("abc");
        while(true) {
            System.out.println("Foo: " + foo);
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        new Thread(new Bar()).start();
        new Thread(new Baz()).start();
    }
}