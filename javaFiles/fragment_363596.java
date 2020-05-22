try {
    Process p = Runtime.getRuntime().exec(new String[] { "bash", "-c", "ps aux | grep process" });
    BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
    String line;
    while ((line = input.readLine()) != null) {
        if (line.contains("process")) {
            // process is running
        }
    }
}
catch (Exception e) {
    // handle error
}