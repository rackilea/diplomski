public static void main(String[] args) throws InterruptedException {
    Unstoppable unStoppable = new Unstoppable();
    Unstoppable unStoppable2 = new Unstoppable();
    Unstoppable unStoppable3 = new Unstoppable();
    System.out.println("I am bout to start");
    unStoppable.start();
    unStoppable2.start();
    unStoppable3.start();
    synchronized (unStoppable) {
        System.out.println("I was just told to wait");
        unStoppable.wait();
    }

    System.out.println(unStoppable.counter);
}

}