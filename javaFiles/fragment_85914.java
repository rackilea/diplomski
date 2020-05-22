import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestCampusImages {

    static final String file_path1 = "CampusImages.txt";
    static final String file_path2 = "CampusImageIDs.txt";
    static final Pattern pID = Pattern.compile("(?<=IDENTIFIER:)[\\d\\s]*");
    static final Pattern pLAT = Pattern.compile("(?<=LATITUDE:)[\\d\\s-.]*");
    static final Pattern pLONG = Pattern.compile("(?<=LONGITUDE:)[\\d\\s-.]*");

    public static void main(String[] args) {
        int id = 0;
        float latitude = 0.0f, longitude = 0.0f;
        try {
            File inFile = new File(file_path1);
            BufferedReader textReader = new BufferedReader(new FileReader(inFile));
            File outFile = new File(file_path2);
            PrintWriter out = new PrintWriter(outFile);
            String inLine = textReader.readLine();
            while (inLine != null) {
                Matcher m = pID.matcher(inLine);
                if (m.find()) {
                    id = Integer.parseInt(m.group().trim());
                }
                m = pLAT.matcher(inLine);
                if (m.find()) {
                    latitude = Float.parseFloat(m.group().trim());
                }
                m = pLONG.matcher(inLine);
                if (m.find()) {
                    longitude = Float.parseFloat(m.group().trim());
                }
                if ((id!=0) && (latitude!=0.0f) && (longitude!=0.0f)) {
                    out.println(String.format("%d | %f | %f ", id,  latitude, longitude));
                    id = 0;
                    latitude = 0.0f; longitude = 0.0f;
                }//end if
                inLine = textReader.readLine();
            }//end while
            textReader.close();
            out.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }//end try
    } //end main

} //end TestCampusImages