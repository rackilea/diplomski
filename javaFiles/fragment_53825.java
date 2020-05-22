public static void main(String[] args) {
    int exitStatus = -1;

    try {
        new JadTool().run(args);
        exitStatus = 0;
    } catch (Exception e) {
        System.err.println("\n" + e.getMessage() + "\n");
    }

    System.exit(exitStatus);
}