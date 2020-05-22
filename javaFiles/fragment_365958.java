public static void main(String args[]) {
    Syncc syncc = new Syncc();

    Thread1 t1 = new Thread1(syncc);
    Thread2 t2 = new Thread2(syncc);

    System.out.println("going to start t1");
    t1.start();
    System.out.println("going to start t2");
    t2.start();
}