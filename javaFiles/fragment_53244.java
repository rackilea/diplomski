import java.io.DataInputStream;
import java.io.FileInputStream;
public class ClassFileVersion {
    // add exception handling, left out only for the example
    public static void main(String[] args) throws Exception {
        String filename = args[0];
        try (DataInputStream in = new DataInputStream(new FileInputStream(filename))) {
            int magic = in.readInt();
            if (magic != 0xcafebabe) {
                System.out.println(filename + " looks not like a Java class file.");
            }
            int minor = in.readUnsignedShort();
            int major = in.readUnsignedShort();
            System.out.printf("majaor.minor: %X.%X hex  %d.%d dec%n", major, minor, major, minor);
        }
    }
}