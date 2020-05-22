import java.io.*;

public class A {

    public static void main(String[] args) throws IOException {
        new A().useDelete();
    }

    public void useDelete() throws IOException {
        File inputFile = new File("src/inware/students.txt");
        File tempFile = new File("src/inware/studentsTemp.txt");

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        int lineToRemove = 2;
        String currentLine;
        int count = 0;

        while ((currentLine = reader.readLine()) != null) {
            count++;
            if (count == lineToRemove) {
                continue;
            }
            writer.write(currentLine + System.getProperty("line.separator"));
        }
        writer.close();
        reader.close();
        inputFile.delete();
        tempFile.renameTo(inputFile);
    }
}