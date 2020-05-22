import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class JspModifierStyleId {

    public static void main(String[] args) throws IOException {
        String lineEnding = "\r\n";
        String baseDir= "C:/path/to/your/directory/";   //Change this to suit your directory

        String origFileName= "OriginalFile.jsp";  //Change this to suit your original file that needs the attribute added
        File origFile = new File(baseDir + origFileName);

        String tempFileName = "TemporaryFile.jsp";
        File tempFile = new File(baseDir + tempFileName);

        Pattern p = Pattern.compile("^(?!.*styleId)\\s*<html:(?:select|option|text|hidden|textarea)\\s.*property=\"([a-zA-Z1-9.]*)\".+");

        FileReader in = new FileReader(origFile);
        FileWriter out = new FileWriter(tempFile);

        BufferedReader br = new BufferedReader(in);
        BufferedWriter bw = new BufferedWriter(out);


        String line;
        while ((line = br.readLine()) != null) {
            Matcher m = p.matcher(line);
            if(m.matches()){
                String strWithStyleId = line.substring(0, m.start(1)) + m.group(1) + "\" styleId=\"" + line.substring(m.start(1));
                bw.write(strWithStyleId + lineEnding);
                System.out.println(strWithStyleId);
            }else {
                bw.write(line + lineEnding);
            }
        }

        br.close();
        bw.close();

        //copies back to original file, BE CAREFUL!!! 
        copyFile(tempFile, origFile);
    }

    public static void copyFile(File sourceFile, File destFile) throws IOException {
        if(!destFile.exists()) {
            destFile.createNewFile();
        }

        FileChannel source = null;
        FileChannel destination = null;

        try {
            source = new FileInputStream(sourceFile).getChannel();
            destination = new FileOutputStream(destFile).getChannel();
            destination.transferFrom(source, 0, source.size());
        }
        finally {
            if(source != null) {
                source.close();
            }
            if(destination != null) {
                destination.close();
            }
        }
    }
}