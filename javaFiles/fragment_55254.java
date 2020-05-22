private static void testProcessRunner() {
    try {
        new ProcessBuilder("notepad").start();
    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}