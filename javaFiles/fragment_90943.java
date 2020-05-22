public static void main(String[] args) {
    try {
        ProcessBuilder pb = new ProcessBuilder("gcc", "calculator.c");
        pb.redirectErrorStream(true);

        Process compile = pb.start();
        consume(compile.getInputStream());

        int result = compile.waitFor();
        if (result == 0) {

            pb = new ProcessBuilder("./a.out");
            pb.redirectErrorStream(true);
            Process execte = pb.start();
            consume(execte.getInputStream());

            System.out.println("Program exited with " + execte.waitFor());

        } else {

            System.err.println("Compiler exited with " + result);

        }
    } catch (IOException | InterruptedException exp) {
        exp.printStackTrace();
    }
}

public static String consume(InputStream is) throws IOException {
    StringBuilder result = new StringBuilder(64);
    int in = -1;
    while ((in = is.read()) != -1) {
        result.append(result);
        // Technquially, you don't need this, but I like to have it as a check
        System.out.print((char) in);
    }
    return result.toString();
}