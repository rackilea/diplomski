public class Main {

private static String FILE_NAME = "file.csv";

public static void main(String[] args) {

    try {
        //create the file using FileWriter
        FileWriter fw = new FileWriter(FILE_NAME);
        //create a File linked to the same file using the name of this one;
        File f = new File(FILE_NAME);
        //Print absolute path
        System.out.println(f.getAbsolutePath());

    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } 

}