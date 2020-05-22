class Foo {
    static void bar(){
       class MyRunnable implements Runnable {
           public void run() {
               System.out.println("No longer anonymous!");
           }    
        };
       Thread baz = new Thread(new MyRunnable());
    }

}