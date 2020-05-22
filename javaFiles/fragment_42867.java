import java.io.*;
public class temp {
    public static void main(String[] args) {
        // define the path to your text file
        String myFilePath = "temp.txt";

        // read and parse the file
        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(myFilePath)));
            String line, name, email;
            // read through the first two lines to get to the data
            line = br.readLine();
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                if (line.contains("|")) {
                    // do line by line parsing here
                    line = line.trim();
                    // split the line
                    String[] parts = line.split("[|]");
                    // parse out the name and email
                    name = parts[1].trim();
                    email = parts[2].trim();
                    // rearrange the name
                    String[] nParts = name.split("  *");
                    if (nParts.length == 3) {
                        name = nParts[1] + " " + nParts[2] + " " + nParts[0];
                    } else {
                        name = nParts[1] + " " + nParts[0];
                    }
                    // all done now, let's print the name and email
                    System.out.println(email + " " + name);
                }
            }
            br.close();
        } catch (Exception e) {
            System.out.println("There was an issue parsing the file.");
        }
    }
}