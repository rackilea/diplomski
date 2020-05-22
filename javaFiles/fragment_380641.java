import java.io.*;
public class Main{

    public static void main(String[] args) {
        File[] fileList = {new File("C:\\Users\\sarah\\OneDrive\\Documents\\input.txt"),
             new File("C:\\Users\\sarah\\OneDrive\\Documents\\output.txt")};
        try {
            for (File file : fileList) {
                if (file.createNewFile()) {
                    System.out.println("File created: " + file.getName());
                } else {
                    System.out.println("File already exists.");
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}