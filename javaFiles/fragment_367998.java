public void incX() {
    synchronized(this) {
        x = ++x;                         // See "Side Note" below
        System.out.println("x is: "+x+"     "+Thread.currentThread().getName());
    }
}