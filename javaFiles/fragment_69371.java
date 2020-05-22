public class Launcher implements Runnable {

    public void run() {
        Process p;
        try {
            p = Runtime.getRuntime().exec("notepad.exe");
            p.waitFor();

            // Do something after the forked process terminates
            System.out.println("The browser is exit");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}