import java.io.*;
import java.util.Arrays;
import java.util.Date;

public class WriteArray {

    public static void main(String[] args) 
        throws ClassNotFoundException, IOException {
        int[] numbers = {1, 2, 3, 4, 5};

        //Create an output stream for file
        ObjectOutputStream output 
            = new ObjectOutputStream(
                  new FileOutputStream("Exercises19_2.bin", true));

        //Write to file
        // 1. Write double
        output.writeDouble(5.5);
        // 2. Write int array object
        output.writeObject(numbers);
        // 3. Write date object
        output.writeObject(new java.util.Date());
        // 4. Write utf string
        output.writeUTF("Exercises19_2.bin");

        // Close the stream
        output.close();

        //Create an input stream for file
        ObjectInputStream input 
            = new ObjectInputStream(
                  new FileInputStream("Exercises19_2.bin"));

        // Read from file
        // 1. Read double
        double doubleValue = input.readDouble();
        System.out.println("Double value: " + doubleValue);
        // 2. Read int array object
        int[] newNumbers = (int[]) (input.readObject());
        System.out.println("Integers: " + Arrays.toString(newNumbers));
        // 3. Read date object
        Date date = (java.util.Date) (input.readObject());
        System.out.println("DateTime: " + date);
        // 4. Read utf string
        String fileName = input.readUTF();
        System.out.println("File name: " + fileName);

        // Close the stream
        input.close();
    }
}