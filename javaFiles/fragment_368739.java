class Foo {
    static void bar(){
        Thread baz=new Thread(new Runnable(){
            public void run(){
                System.out.println("quux");
            }
        }
    }
}