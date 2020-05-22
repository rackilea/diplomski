private static void executeJps() throws IOException {
    Process p = Runtime.getRuntime().exec("jps -l");
    String line = null;
    BufferedReader in = new BufferedReader(new InputStreamReader(
                                                p.getInputStream(), "UTF-8"));

    while ((line = in.readLine()) != null) {
        String [] javaProcess = line.split(" ");
        if (javaProcess.length > 1 && javaProcess[1].endsWith("ClassName")) {
            System.out.println("pid => " + javaProcess[0]);
            System.out.println("Fully Qualified Class Name => " + 
                                           javaProcess[1]);
        }
    }
}