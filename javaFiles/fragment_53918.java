import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Test {

    public static void main(String[] args) {

        File reportNew = null;
        File writeToDir = null;

        BufferedReader br = null;
        BufferedWriter bw = null;
        StringWriter sw = null;

        List<File> fileList = new ArrayList<File>();

        SimpleDateFormat ft = new SimpleDateFormat("yyyymmdd_hh_mm_ss_ms");


        try {

            //Read report.new file
            reportNew = new File("c:\\temp\\report.new");

            //Create temp directory for newly created files         
            writeToDir = new File("c:\\temp");
            //tempDir.mkdir();

            //Separate report.new into many files separated by a token
            br = new BufferedReader(new FileReader(reportNew));
            sw = new StringWriter();
            new StringBuilder();



            String line;
            int fileCount = 0;

            while (true) {

                line=br.readLine();

                if (line == null || line.contains("%PDF")) {

                    if (!sw.toString().isEmpty()) {

                        fileCount++;

                        File _file = new File(writeToDir.getPath() 
                                            + File.separator
                                            + fileCount
                                            + "_"
                                            + ft.format(new Date())
                                            + ".htm");

                        _file.deleteOnExit();
                        fileList.add(_file);


                        bw = new BufferedWriter(new FileWriter(_file));
                        bw.write(sw.toString());

                        bw.flush();
                        bw.close();
                        sw.getBuffer().setLength(0);

                        System.out.println("File " 
                                            + _file.getPath()
                                            + " exists "
                                            + _file.exists());
                    }

                    if (line == null)
                        break;
                    else
                        continue;
                }

                sw.write(line);
                sw.write(System.getProperty("line.separator"));
            }

        } catch ( Exception e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}