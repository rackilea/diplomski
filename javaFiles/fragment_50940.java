ProcessBuilder pb = new ProcessBuilder(
        new String[]{
            "find", 
            "/XXX/XXX/Documents/test1",
            "-mtime", "+10",
            "-type", "f",
            "-delete"
        }
);
pb.redirectErrorStream(true);
try {
    Process p = pb.start();
    InputStream is = p.getInputStream();
    int in = -1;
    while ((in = is.read()) != -1) {
        System.out.print((char)in);
    }
    int exitWith = p.exitValue();
    System.out.println("\nExited with " + exitWith);
} catch (IOException exp) {
    exp.printStackTrace();
}