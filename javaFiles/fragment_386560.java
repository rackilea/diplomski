public String getPlate(String image) throws IOException, InterruptedException{
        ProcessBuilder pb =
            new ProcessBuilder("alpr", "-c eu", "-j on", "-n 1", image);
        Process p = pb.start();

        BufferedReader reader =
            new BufferedReader(new InputStreamReader(p.getInputStream()));
        StringBuilder builder = new StringBuilder();
        String line;
        while ( (line = reader.readLine()) != null) {
               builder.append(line);
               builder.append(System.getProperty("line.separator"));
        }

        // wait for the child process *after*
        // reading all its output
        p.waitFor();

        String result = builder.toString();
        return result;
}