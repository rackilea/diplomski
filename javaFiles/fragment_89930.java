import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class stack2 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try{

                File myFile = new File("D:\\light.txt").getAbsoluteFile();
                FileInputStream in = new FileInputStream(myFile);
                OutputStream out = new FileOutputStream("test.txt");

                int bytes = 0;
                byte[] buffer = new byte[8192];
                int len;

                while ((len = in.read(buffer)) > 0) {
                    out.write(buffer, 0, len);
                    bytes += len;
                }

                System.out.println("Transfer completed, " + bytes + " bytes sent");

                out.flush();



            }catch(Exception e){
                System.out.println(e.getMessage());
            }

    }

}