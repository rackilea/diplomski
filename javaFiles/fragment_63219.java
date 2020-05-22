import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.security.MessageDigest;


public class CheckSumFileTest 
{

    private File buildChecksumFile(File fileToCheck, String filePrefix, String checksumAlgorithm) throws Exception
    {
        String checksum = null;
        File checksumFile = null;
        String tempDir = System.getProperty("java.io.tmpdir");
        try {
            checksumFile = new File(tempDir, filePrefix+"."+ checksumAlgorithm.toLowerCase());
            checksumFile.createNewFile();
            checksumFile.deleteOnExit();
        } catch (Exception e1) {
            e1.printStackTrace();
            throw e1;
        }
        FileWriter fw = null;
        try {
            checksum = checkSum(fileToCheck,checksumAlgorithm);
            fw = new FileWriter(checksumFile);
            fw.write(checksum);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        finally
        {
            if(fw !=null)
                fw.close();
        }

        return checksumFile;
    }

    private static String checkSum(File file, String checksumAlgorithm) throws Exception
    {
        MessageDigest digest = MessageDigest.getInstance(checksumAlgorithm);

        InputStream input = null;
        StringBuffer sb = new StringBuffer();
        try{
            input = new FileInputStream(file);
            byte[] buffer = new byte[8192];
            do {
                int read = input.read(buffer);
                if(read <= 0)
                    break;
                digest.update(buffer, 0, read);
            } while(true);
            byte[] sum = digest.digest();

            for (int i = 0; i < sum.length; i++) {
                sb.append(Integer.toString((sum[i] & 0xff) + 0x100, 16).substring(1));
            }

        }catch(IOException io)
        {

        }finally{
            if(input != null)
                input.close();
        }

        return sb.toString();
    }

    private static String checkSumInStream(InputStream stream, String checksumAlgorithm) throws Exception
    {
        MessageDigest digest = MessageDigest.getInstance(checksumAlgorithm);

        InputStream input = null;
        StringBuffer sb = new StringBuffer();
        try{
            input = stream;
            byte[] buffer = new byte[8192];
            do {
                int read = input.read(buffer);
                if(read <= 0)
                    break;
                digest.update(buffer, 0, read);
            } while(true);
            byte[] sum = digest.digest();

            for (int i = 0; i < sum.length; i++) {
                sb.append(Integer.toString((sum[i] & 0xff) + 0x100, 16).substring(1));
            }

        }catch(IOException io)
        {

        }finally{
            if(input != null)
                input.close();
        }

        return sb.toString();
    }

    private boolean checkIntegrity(String targetFileName, String checksumFileName, String checksumAlgorithm) throws Exception
    {
        FileInputStream stream = null;
        BufferedReader br = null;
        InputStreamReader ipsr = null;
        File checksumFile = null;
        String checksumString="";
        File targetFile = new File(targetFileName);
        try{
            checksumFile = new File(checksumFileName);
            stream = new FileInputStream(checksumFile);
            ipsr = new InputStreamReader(stream);
            br = new BufferedReader(ipsr);

            //In checksum file : only one line to read
            checksumString = br.readLine();

        }finally
        {
            if(br != null)
                br.close();
            if(ipsr != null)
                ipsr.close();
            if(stream != null)
                stream.close();
        }


        if(checksumString.equals(checkSum(targetFile,checksumAlgorithm)))
        {
            return true;
        }
        else
        {
            return false;
        }
    }



    /**
     * @param args
     */
    public static void main(String[] args) 
    {
        String str = "Amine";
        InputStream stream = new ByteArrayInputStream(str.getBytes());
        //step1
        try {
            System.out.println(checkSumInStream(stream,"MD5"));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //step2
        File file = new File("c:/test.txt");

        // if file doesnt exists, then create it
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        FileWriter fw;
        BufferedWriter bw;

        try {
            fw = new FileWriter(file.getAbsoluteFile());
            bw = new BufferedWriter(fw);
            bw.write(str);
            bw.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        try {
            System.out.println(checkSum(file, "MD5"));
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Done");
    }

}