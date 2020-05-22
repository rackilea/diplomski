import java.net.*; import java.io.*;

public class asp {

    public static URLConnection connection;

    public static void main(String[] args) {

        try {
        System.out.println("Hello World!"); // Display the string.
            try {
            URLConnection connection = new URL("http://localhost/post.php?players").openConnection();
            InputStream response = connection.getInputStream();
            System.out.println(response);

            }catch(MalformedURLException rex) {
                System.out.println("Oops my url isn't right");
        }catch(IOException ex) {}
    }    
}