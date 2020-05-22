public static boolean supports64Bit() {
    try {
        final Process process = Runtime.getRuntime().exec("java -d64 -version");
        try {
            return process.waitFor() == 0;
        } finally {
            process.getInputStream().close();
            process.getOutputStream().close();
            process.getErrorStream().close();
        }
    } catch (IOException e) {
        // log error here?!
        return false;
    }
}