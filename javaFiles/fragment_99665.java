public void putfile() {

    try {                      
        ProcessBuilder builder = new ProcessBuilder("winscp", "/script=D:\\command.txt");
        builder.redirectErrorStream(true);

        Process process = builder.start();

        // read output from the process
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder outputBuilder = new StringBuilder();
        String line;
        do {
           line = reader.readLine();
           if (line != null) { outputBuilder.append(line).append('\n'); }
        } while (line != null);

        reader.close();

        String output = outputBuilder.toString();
        // inspect output for error messages.

        int exitCode = process.waitFor();
        // see if exit code is 0 (success) or != 0 (error)
    }
    catch(Exception e) {
        System.out.println("Exception in index.jsp:"+e.getMessage());
    }
}