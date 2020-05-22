public class TestServletListener implements ServletContextListener {

@Override
public void contextInitialized(ServletContextEvent arg0) {
    System.out.println("Starting app, running 5 tests ...");

    // do tests ...
    for (int i = 0; i < 5; i++) {
        System.out.println("testing ... " + i);
        waitFor(1000);
    }
    // If a test failed call:
    System.out.println("test failed!");
    new ShutdownTask().start();
}

@Override
public void contextDestroyed(ServletContextEvent arg0) {
    System.out.print("Stopping app, cleaning up (takes 3 sec) ... ");
    waitFor(3000);
    System.out.println("done");
}

private void waitFor(int i) {
    try {
        Thread.sleep(i);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}

class ShutdownTask extends Thread {

    @Override
    public void run() {
        try {
            Socket s = new Socket("127.0.0.1", 8015);
            PrintStream os = new PrintStream(s.getOutputStream());
            os.println("shutdown");
            s.close();
            System.out.println("Shutting down server ...");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
}