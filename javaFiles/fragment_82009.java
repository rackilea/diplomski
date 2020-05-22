ProcessBuilder pb = new ProcessBuilder("python", "setup.py", "py2exe");
pb.inheritIO();
try {
    Process p = pb.start();
    p.waitFor(); // <-- wait for the process to finish
} catch (Exception e) {
    e.printStackTrace();
}