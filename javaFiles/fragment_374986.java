> public  class morethreads implements Runnable {
>     public void run() {
>         for (int i = 0; i<20; i++)
>             System.out.println("Hello from a thread!" + i);
>     }
>     public static void main(String args[]) {
>         Thread[] hello = new Thread [10];//amount of threads
>         for(int b =0; b < hello.length; b++){
>             hello[b] = new Thread(new morethreads());
>             hello[b].start();
>         }
>     } }