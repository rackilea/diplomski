import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import junit.framework.Assert;

import java.io.*;

class CmdTesting {



    @Test
    void test() throws Exception {
        try {
            CmdLineUI obj = new CmdLineUI();

            InputStream myInputStream = null;

            String unknownCommandString = "hello world";
            String exitString = CmdLineUI.EXIT;

            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            DataOutputStream dos = new DataOutputStream(baos);
            dos.writeUTF(unknownCommandString);

            byte[] inputBytes = baos.toByteArray();

            ByteArrayInputStream bais = new ByteArrayInputStream(inputBytes);
            myInputStream = bais;

            ByteArrayOutputStream myOutputStream = new ByteArrayOutputStream();

            obj.runUi(myInputStream, myOutputStream);

            ByteArrayInputStream outputIS = new ByteArrayInputStream(myOutputStream.toByteArray());

            DataInputStream dis = new DataInputStream(outputIS);

            dis.readUTF();

            String expected = "hello world";

            assertEquals(expected, unknownCommandString);

        } catch (Exception ex) {
            ex.getLocalizedMessage();
        }

    }

    @Test
    public void writeMessage() throws Exception {

        File file = new File("/home/sami/Desktop/file.txt");
        String str = "Hello";

        BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));
        writer.append(' ');
        writer.append(str);

        writer.close();
    }


    @Test
    public void reamessage() throws Exception {
        File file=new File("/home/sami/Desktop/file.txt");

        BufferedReader reader = new BufferedReader(new FileReader(file));
        reader.read();
    }
}