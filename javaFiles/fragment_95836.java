import java.io.*;
class TestClass {
    public static void main(String args[]) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("test.txt"));
        for(int i=0;i<65535;i++)
            writer.write("Happy Diwali!\n");         
        writer.close(); 
    }
}