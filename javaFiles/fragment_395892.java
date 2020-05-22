public class Constructor_benifit{
    public static void main(String[] args){
        System.out.println("In primary Thread");
        Thread thread_object=new A("Test string for secondary thread");
        thread_object.start();
    }
    static class A extends Thread
    {
        private String to_print;
        public A(String to_print){
            this.to_print=to_print;
        }
        public void run(){
            System.out.println(to_print);
        }

    }
}