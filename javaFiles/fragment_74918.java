public static void main(String[] args)
{
    t1 = new MyThread(1);       
    Thread tc = new Thread(t1);
    tc.start();

    t2 = new MyThread(2);
    tc = new Thread(t2);
    tc.start();
}
}