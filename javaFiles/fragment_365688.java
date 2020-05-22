public class CmdTest {

    public static void main(String[] args) throws Exception {

        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "D: && cd program Files\\wkhtmltopdf\\bin && dir");

        // Here you need to set the directory in my case D:
        pb=pb.directory(new File("D:\\"));
        pb.redirectErrorStream(true);
        Process p = pb.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while (true) {
            line = r.readLine();
            if (line == null) { break; }
            System.out.println(line);
        }
    }

}