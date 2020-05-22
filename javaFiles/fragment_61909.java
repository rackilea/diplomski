import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileWrite {
    public static void LineDelete(String Filename, String Content)
            throws IOException {
        BufferedWriter out = null;
        File flights = new File("AppData/" + Filename);
        File temp = new File("AppData/temp.txt");
        FileWriter fstream = null;

        try {
            Scanner sc = new Scanner(flights);
            fstream = new FileWriter("AppData/temp.txt", true);
            out = new BufferedWriter(fstream);
            boolean exis = temp.exists();
            if (exis) {
                temp.delete();
                temp = new File("AppData/temp.txt");
                boolean createNewFile = temp.createNewFile();
            } else {
                boolean creatNewFile = temp.createNewFile();
            }
            String f;
            while (sc.hasNextLine()) {
                f = sc.nextLine();
                if (!f.equals(Content)) {
                    out.newLine();
                    out.write(f);
                }

            }
        } catch (IOException ex) {
            Logger.getLogger(FileWrite.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                out.close();
            } catch (Exception e) {
                Logger.getLogger(FileWrite.class.getName()).log(Level.SEVERE, null, e);
            }
        }

        if(flights.exists()){           
            flights.delete();
            File flightsn = new File("AppData/" + Filename);
            temp.renameTo(flightsn);
        }
    }
}