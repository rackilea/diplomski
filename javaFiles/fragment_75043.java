import java.io.*;
public class XORTest
{
    public static void main(String args[])throws IOException
    {
        RandomAccessFile reader=new RandomAccessFile("a.txt","r");
        RandomAccessFile writer=new RandomAccessFile("b.txt","rw");
        byte[] buffer  = new byte[256];

        reader.read(buffer);
        xor(buffer);
        writer.write(buffer);
        while(true)
        {
            int o = reader.read(buffer);
            if(o < 0)
                break;
            writer.write(buffer);

        }
        writer.close();
        reader.close();
    }

    public static byte[] xor(byte[] a) {
        int key=11;
        byte[] result = new byte[a.length];

        for (int i = 0; i < a.length; i++) {
                    a[i] = (byte)(a[i] ^ key);                     }

        return result;
    }
}