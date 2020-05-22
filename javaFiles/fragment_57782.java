import java.io.File;
import java.io.IOException;

public class Driver {

    public static void main(String[] args) {
        final String[] FILE_NAMES = {"\\files\\READTHIS.txt",
                                     "\\files\\sub-files\\Help.txt",
                                     "\\files\\sub-files\\Config.txt"
                                    };
        Runtime rt = Runtime.getRuntime();

        // get the absolute path of the directory
        File cwd = new File(new File("").getAbsolutePath());

        // iterate over the hard-coded file names opening each in notepad
        for(String file : FILE_NAMES) {
            try {
                Process p = rt.exec("notepad " + cwd.getAbsolutePath() + file);
            } catch (IOException ex) {
                // Logger.getLogger(NumberAdditionUI.class.getName())
                // .log(Level.SEVERE, null, ex);
            }
        }

    }
}