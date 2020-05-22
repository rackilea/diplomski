public class AlmostInfinite extends Thread {
    public void run() {
        while (!Thread.interrupted()) {
            /* Do some work, not too long */
        }
        cleanUp();
    }

    private cleanUp() {
        /* close network connections, files and other resources */
    }
}

ActionListener panic(AlmostInfinite t)
{
    t.interrupt();
}