public void executeScript() throws IOException, InterruptedException {
    Process p = Runtime.getRuntime().exec("sh /root/Desktop/chat/script.sh");
    p.waitFor();

    BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
    BufferedReader errorReader = new BufferedReader(new InputStreamReader(p.getErrorStream()));


    String line = "";
    while ((line = reader.readLine()) != null) {
        System.out.println(line);
    }

    line = "";
    while ((line = errorReader.readLine()) != null) {
        System.out.println(line);
    }
}