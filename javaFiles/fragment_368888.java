ProcessBuilder builder = new ProcessBuilder("emacs", "/home/test.txt");

// Makes Process use Java program’s stdin, stdout and stderr.
builder.inheritIO();

int exitValue = builder.start().waitFor();