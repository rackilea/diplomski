import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

public class TestSerialization {

    public static void main(final String[] array) throws FileNotFoundException, IOException, ClassNotFoundException {
        // save object to file
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("/tmp/file")));
        oos.writeObject(array); // where myArray is String[]

        // load object from file
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("/tmp/file")));
        String[] read = (String[]) ois.readObject();

        System.out.println(Arrays.toString(read));
    }

}