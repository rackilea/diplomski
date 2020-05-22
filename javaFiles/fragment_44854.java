public class Main{
    public static int v = 5;

    public static void main(String[] args) throws Exception{
        new Thread(new A()).start();
        Thread.sleep(5000);
        new Thread(new B()).start();
    }
}

class A implements Runnable{
    public void run(){
        System.out.println(Main.v);
        Main.v = 6;
    }
}

class B implements Runnable{
    public void run(){
        System.out.println(Main.v);
    }
}