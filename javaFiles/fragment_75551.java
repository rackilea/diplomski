public static void runCmd (String[] cmd) {

    try {
        Process p = Runtime.getRuntime().exec(cmd);
        BufferedReader r = new BufferedReader(
            new InputStreamReader (
                p.getInputStream()
            )
        );
    } catch(Exception e) {
    }
}