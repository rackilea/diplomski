try {
    ProcessBuilder pb = new ProcessBuilder(new String[]{"java", "-jar", "Your.jar"});
    pb.redirectError();
    //pb.directory(new File("you/path"));
    Process ps = pb.start();
    try (java.io.InputStream is = ps.getInputStream()) {
        int read = -1;
        while ((read = is.read()) != -1) {
            System.out.print((char) read);
        }
    }
    System.out.println("Command exited with: " + ps.waitFor());
} catch (IOException | InterruptedException exp) {
    exp.printStackTrace();
}