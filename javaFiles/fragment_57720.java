public static void main(String[] args) {

    CountDownLatch cdl = new CountDownLatch(1);

    // pass the CountDownLatch into display
    GLDisplay display = new GLDisplay(cdl);
    display.start();

    // wait for the latch to have been counted down in the disp thread
    try
    {
        cdl.await();
    }
    catch (InterruptedException e)
    {
        e.printStackTrace();
    }

    GLShader shader = new StaticShader();
}