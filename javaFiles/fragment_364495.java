package test;

public class Class {

    public static void main(String[] args) {
        sayHiAsLanguages();
    }

    public static void sayHiAsLanguages() {
        new Thread(new Runnable(){
            public void run(){
                try{
                    //Change Thread sleep amount to see delay difference
                    System.out.println("How do you say hi in English?");
                    Thread.sleep(500);
                    System.out.println("Hi");

                    Thread.sleep(1000);
                    System.out.println("How do you say hi in Spanish?");
                    Thread.sleep(500);
                    System.out.println("Hola");

                    Thread.sleep(1000);
                    System.out.println("How do you say hi in Italian?");
                    Thread.sleep(500);
                    System.out.println("Ciao");

                    Thread.sleep(1000);
                    System.out.println("How do you say hi in French?");
                    Thread.sleep(500);
                    System.out.println("Bonjour");

                    Thread.sleep(1000);
                    System.out.println("How do you say hi in German?");
                    Thread.sleep(500);
                    System.out.println("Guten tag");

                }catch(InterruptedException ie){
                    ie.printStackTrace();
                }
            }
        }).start();
    }
}