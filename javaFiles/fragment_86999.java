import java.io.*;

public class StringRepl {
    public void doReplace(String oldFileName, String newFileName) {
        File oldFile = new File(oldFileName);
        File tempFile = new File(newFileName);

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(oldFile), "utf-8"));

            PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(tempFile), "utf-8"));
            BufferedWriter bw = new BufferedWriter(writer);
            String currentLine;
            String del = "hi";
            while((currentLine = reader.readLine()) != null)
            {
                //System.out.println(currentLine);

                if (currentLine.contains(del))
                    currentLine = currentLine.replace(del, "");
                bw.write(currentLine);
                bw.newLine();

            }
            bw.close();
            reader.close();
            writer.close();
            //tempFile.renameTo(oldFile);
        } catch (FileNotFoundException fnfe) {
            System.out.print("No file found: " + oldFileName);
        } catch (UnsupportedEncodingException uee) {
            System.out.print("'utf-8' not supported");
        } catch (IOException ioe) {
            System.out.print("Error using file!");
            ioe.printStackTrace();
        }
    }

    public static void main(String[] args) {
        StringRepl sr = new StringRepl();
        sr.doReplace("o.txt","n.txt");
    }
}