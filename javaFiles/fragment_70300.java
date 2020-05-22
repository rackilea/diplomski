ProcessBuilder builder = new ProcessBuilder(cmd);
builder.inheritIO();

Process process = builder.start();
process.waitFor();

Files.delete(script);