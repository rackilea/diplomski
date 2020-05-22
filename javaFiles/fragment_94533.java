import java.io.IOException;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) {
        Process myProcess = null;
        try {
            myProcess = Runtime.getRuntime().exec("cmd /c C:\\Users\\geisterfurz007\\Desktop\\example.bat");
        } catch (IOException e) {
            e.printStackTrace();
        }
        startReadingThread(myProcess).start();
    }

    private static Thread startReadingThread(Process myProcess) {
        InputStream stream = myProcess.getInputStream();
        return new Thread(() -> {
            int character;
            try {
                while (myProcess.isAlive() || stream.available() > 0) {

                    if ((character = stream.read()) == -1) {
                        break;
                    }
                    System.out.write(character);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}