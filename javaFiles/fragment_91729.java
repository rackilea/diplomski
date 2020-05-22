import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;

public class DetectLoggedInUser {

    public static void returnUserName() {
        try {
            File file = new File("d:\\TestFolder\\UsersloggedIn.txt");

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fileWritter = new FileWriter(file, true);
            BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
            String content = "\n UserName=" + System.getProperty("user.name")
                    + " || Date and Time= " + new Date();
            bufferWritter.write(content);
            bufferWritter.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String args[]) {
        returnUserName();
    }
}