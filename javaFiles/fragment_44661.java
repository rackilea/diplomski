public class ReaderThread extends Thread {

    private BufferedReader reader = null;
    public ReaderThread(BufferedReader reader) {
        this.reader = reader;
    }

    @Override
    public void run() {
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch(IOException exception) {
            System.out.println("!!Error: " + exception.getMessage());
        }
    }
}