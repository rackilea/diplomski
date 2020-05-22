import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Test implements Serializable{

    private int a = 10;
    private double b = 7.5;
    private String m = "valu";

    public static void main(String[] args) throws IOException {
        Test t = new Test();

        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Test.dat"));
        output.writeObject(t);
        output.close();
    }

}