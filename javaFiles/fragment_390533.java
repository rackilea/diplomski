public class TestClass extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Thread playThread ;

    TestClass() {

         playThread = new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("DO SOME THING HERE");
                System.out.println("SONG WILL PLAY.....");


            }
        });
    }

    public void startMyPlayer() {
        System.out.println("PLAYING NOW...");
        playThread.start();
    }

    public void pauseMyPlayer() throws InterruptedException {
        System.out.println("PAUSED NOW...");
        playThread.wait();
    }

    public void resumeMyPlayer() {
        System.out.println("RESUMING NOW...");
        playThread.notify();
    }
}