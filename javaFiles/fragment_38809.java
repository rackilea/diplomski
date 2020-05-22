import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Week04 {
    public static void main(String[] args) throws IOException {
        String theFile;
        theFile = getTheFileName();
        double theAverage;
        theAverage = getTheAverage(theFile);
        displayTheResult(theAverage,"The average is; ");
    }

    public static String getTheFileName() {
        String theFile;
        JFileChooser jfc = new JFileChooser();
        jfc.showOpenDialog(null);
        return theFile = jfc.getSelectedFile().getAbsolutePath();
    }

    public static double getTheAverage(String s) throws IOException {
        double value = 0, numValues = 0;
        FileReader fr = new FileReader(s);
        BufferedReader br = new BufferedReader(fr);
        String aLine;
        while ( (aLine = br.readLine()) != null) {
            if (aLine.equals("")) continue;
            value += Double.parseDouble(aLine);
            numValues++;
        }
        if (numValues > 1) {
            return value/numValues;
        } else {
            return value;
        }

    }
    public static void displayTheResult(double x, String s){
            JOptionPane.showMessageDialog(null,s + x);
    }
}