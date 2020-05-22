ProcessBuilder builder = new ProcessBuilder("/usr/bin/env", "python",
        "-c", "print(2*2); exit()");
builder.inheritIO();
try {
    Process process = builder.start();
    process.waitFor();
} catch (Exception e) {
    e.printStackTrace();
}