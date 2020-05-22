import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

    public static void main(String[] args) {

        // File name
        String fileName = "names.txt";
        String separator = ", ";

        String line;

        try (FileReader fileReader = new FileReader(fileName);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            while ((line = bufferedReader.readLine()) != null) {
                String[] elements = line.split(separator);

                if (elements.length == 2) {
                    System.out.printf("%s %s\n", elements[1], elements[0]);
                } else {
                    System.out.println("Wrong line: " + line);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}