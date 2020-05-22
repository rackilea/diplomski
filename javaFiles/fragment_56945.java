import java.awt.Desktop;
    import java.io.BufferedReader;
    import java.io.File;
    import java.io.FileInputStream;
    import java.io.FileNotFoundException;
    import java.io.IOException;
    import java.io.InputStreamReader;

    public class OpenFolder {
        public static void main(String[] args) throws IOException {
            System.out.println(findProcess("process_name_here"));
        }

        public static boolean findProcess(String processName) throws IOException {
            String filePath = new String("");
            File directory = new File("/proc");
            File[] contents = directory.listFiles();
            boolean found = false;
            for (File f : contents) {
                if (f.getAbsolutePath().matches("\\/proc\\/\\d+")) {
                    filePath = f.getAbsolutePath().concat("/status");
                    if (readFile(filePath, processName))
                        found = true;
                }
            }
            return found;
        }

        public static boolean readFile(String filename, String processName)
        throws IOException {
            FileInputStream fstream = new FileInputStream(filename);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            strLine = br.readLine().split(":")[1].trim();
            br.close();
            if (strLine.equals(processName))
                return true;
            else
                return false;
        }
    }