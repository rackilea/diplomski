import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadInts {
    private String fname;

    public ReadInts(String fname) {
        this.fname = fname;
    }

    public void read() throws IOException {
        File file = new File(fname);

        System.out.println("Reading from: " + file.getAbsolutePath());

        BufferedReader inputReader = new BufferedReader(new FileReader(file));

        String line;
        while ((line = inputReader.readLine()) != null) {
            int integer = Integer.parseInt(line);
            System.out.println(integer);
        }

        inputReader.close();
    }

    public static void main(String[] args) throws IOException {
        ReadInts ri = new ReadInts("mydata.dat");
        ri.read();
    }
}