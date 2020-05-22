import java.io.*;

public class Test {
    public static void main(String args[]){
        InputStream is;
        try {
            is = new   FileInputStream("Testing_2.txt");
            DataInputStream dis = new DataInputStream(is);
            OutputStream os = new  FileOutputStream("Testing_3.txt");
            DataOutputStream dos = new DataOutputStream(os);
            byte[] buff = new byte[dis.available()];
            dis.readFully(buff);
            char temp = 0;
            boolean start = false;
            for(byte b:buff){
                int i = b & 0xff;
                char c = (char)i;
                if(temp == 'Ð' && c == 'Ï' ){
                    start = true;  
                }
                if(start){
                    dos.write(c);
                }
                temp = c;

            }  
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }
    }
}