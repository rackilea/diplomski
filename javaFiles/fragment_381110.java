import java.io.*;
import java.util.*;

public class Ser {
    public static void main(String[] args) throws Exception {

        // Serialize an int[]
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("test.ser"));
        out.writeObject(new double[] {3.1, 1.1});
        out.flush();
        out.close();

        out = new ObjectOutputStream(new FileOutputStream("test1.ser"));
        HashMap<String, String> aa = new HashMap<String, String>();
        aa.put("bla" , "bla1");
        out.writeObject(aa);
        out.flush();
        out.close();

        // Deserialize the int[]
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("test.ser"));
        double[] array = (double[]) in.readObject();
        in.close();

        // Print out contents of deserialized int[]
        System.out.println("It is " + (array instanceof Serializable) + " that we can serialize double[]");
        for (int i=0; i<array.length; i++) {
            System.out.print(", " + array[i]);
        }
        System.out.println();

        in = new ObjectInputStream(new FileInputStream("test1.ser"));
        HashMap<String, String> bb = (HashMap<String, String>) in.readObject();
        in.close();

        // Print out contents of deserialized int[]
        System.out.println("It is " + (bb instanceof Serializable) + " that we can serialize HashMap");
        System.out.print(bb);
        System.out.println();
    }
}