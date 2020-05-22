package test;

import org.apache.commons.codec.binary.Base64InputStream;
import org.apache.commons.codec.binary.Base64OutputStream;

import java.io.*;
import java.util.Arrays;

public class Test {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        double[] array = {0.0, 1.1, 2.2, 3.3};
        String stringValue = serialize(array);
        map("Key", stringValue);
    }

    public static void map(String key, String value) throws ClassNotFoundException, IOException {
        double[] array = deserialize(value);
        System.out.println("Key=" + key + "; Value=" + Arrays.toString(array));
    }

    public static String serialize(double[] array) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Base64OutputStream base64OutputStream = new Base64OutputStream(byteArrayOutputStream);
        ObjectOutputStream oos = new ObjectOutputStream(base64OutputStream);
        oos.writeObject(array);
        oos.flush();
        oos.close();
        return byteArrayOutputStream.toString();
    }

    public static double[] deserialize(String stringArray) throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(stringArray.getBytes());
        Base64InputStream base64InputStream = new Base64InputStream(byteArrayInputStream);
        ObjectInputStream iis = new ObjectInputStream(base64InputStream);
        return (double[]) iis.readObject();
    }
}