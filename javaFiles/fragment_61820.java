package my.pkg;

import java.io.InputStream;
import java.util.Scanner;

public class ReadSchema {

    public static void main(String[] args) {
        InputStream inStream = ReadSchema.class.getClassLoader().getResourceAsStream("schema.json");
        Scanner scan = new Scanner(inStream);
        scan.useDelimiter("\\A");
        String json = scan.next();

        System.out.println(json);
        scan.close();
    }

}