public void checkDisks() throws IOException, InterruptedException {
    Process p = Runtime.getRuntime().exec("df -h");
    int exitValue = p.waitFor();
    System.out.println("Process exitValue:" + exitValue);


    BufferedReader reader = new BufferedReader(new InputStreamReader(
                                                 p.getInputStream()));
    String line = reader.readLine();
    while (line != null) {
        line = reader.readLine();
        System.out.println(line);
    }
}