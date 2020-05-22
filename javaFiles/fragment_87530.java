// Take input from a file, output and error go to user console
pb = new ProcessBuilder("./program")
         .redirectInput(new File("./my-file.txt"))
         .redirectOutput(Redirect.INHERIT)
         .redirectError(Redirect.INHERIT);
Process p = pb.start();
int rc = p.waitFor();