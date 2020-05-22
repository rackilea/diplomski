import java.io.*;

public class Test
{
    // Just for the sake of a simple test program!
    public static void main(String[] args) throws Exception
    {
        RandomAccessFile file = new RandomAccessFile("file.dat", "rw");

        file.seek(100);
        file.write(0);
        file.close();
    }
}