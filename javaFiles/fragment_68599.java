class A {
    public static void main(String[] args) {
        try {
            ProcessBuilder builder = new ProcessBuilder("echo", "foo");
            builder.redirectError(ProcessBuilder.Redirect.INHERIT);
            builder.redirectOutput(ProcessBuilder.Redirect.INHERIT);
            Process p = builder.start();
            p.waitFor();
        } catch (Exception e) {
            System.err.println(e);
            System.exit(1);
        }
    }
}