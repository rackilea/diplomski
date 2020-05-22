ProcessBuilder pb = new ProcessBuilder(new String[] {cmd, parameter1, parameter2, ...});
Process process = pb.start();

InputStream is = process.getInputStream();
InputStream isErr process.getErrorStream();

// Spawn some threads to process the streams

int exitValue = process.waitFor();

if (exitValue == 0) {

    System.out.println("All is good with the world");

} else {

    // Handle error     

}