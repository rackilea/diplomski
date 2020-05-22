import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LineBuilder {

    private String fileName;

    public LineBuilder(String fileName) {
        this.fileName = fileName;
    }

    public List<String> build() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
        List<String> lines = new ArrayList<String>();
        String line = null;
        try {
            while((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch(IOException e) {
            throw e;
        } finally {
            reader.close();
        }
        return lines;
    }
}