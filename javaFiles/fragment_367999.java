public void incX() {
    int y;                               // Local variable
    synchronized(this) {
        y = ++x;                         // No longer and odd thing to do
    }
    System.out.println("x is: "+y+"     "+Thread.currentThread().getName());
}