public static void main(String[] args) throws IOException {
    String[] cmd = { "CMD", "/C", "dir" };
    ProcessBuilder probuilder = new ProcessBuilder(cmd);
    Process p = probuilder.start();
    BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
    String readline;
    int i = 0;
    while ((readline = reader.readLine()) != null) {
        System.out.println(++i + " " + readline);
    }
}