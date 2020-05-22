public class copyJava {
    public static void main(String args[]) throws IOException,
            InterruptedException {
        Process p = null;
        String[] command = {
                "cmd",
                "/c",
                "for /f \"delims==\" %k in ('dir C:\\Project\\workspace\\downloads\\*.java /s /b') do copy \"%k\" C:\\Project\\workspace\\javaRepo" };
        ProcessBuilder copyFiles = new ProcessBuilder(command);
        copyFiles.redirectErrorStream(true);
        p = copyFiles.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                p.getInputStream()));
        String line;
        do {
            line = reader.readLine();
            if (line != null) {
                System.out.println(line);
            }
        } while (line != null);
        reader.close();
        p.waitFor();
    }
}