class Foo {
    static void bar(){
       // SNIP
    }
    static class MyRunnable implements Runnable {
        public void run() {
            System.out.println("No longer anonymous!");
        }    
    }
}