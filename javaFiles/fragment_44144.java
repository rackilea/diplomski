public class BatchEnter {

    public static void main(String[] args) throws Exception {
        List<String> params = Arrays.asList(new String[] { "cmd", "/C", "C:/test/test.bat" });
        ProcessBuilder builder = new ProcessBuilder(params);
        builder.directory(new File("C:/test")).redirectErrorStream(true);
        final Process p = builder.start();

        final BufferedReader wr = new BufferedReader(new InputStreamReader(p.getInputStream()));
        final BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(p.getOutputStream()));
        String line = "";
        try {
            while ((line = wr.readLine()) != null) {
                if (line.equals("Press any key")) {
                    String newLine = "\n\r";
                    writer.write(newLine);

                }
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        p.waitFor();
    }
}