/* Create the ProcessBuilder */
ProcessBuilder pb = new ProcessBuilder(commandArr);
pb.redirectErrorStream(true);

/* Start the process */
Process proc = pb.start();
System.out.println("Process started !");

/* Read the process's output */
String line;             
BufferedReader in = new BufferedReader(new InputStreamReader(
        proc.getInputStream()));             
while ((line = in.readLine()) != null) {
    System.out.println(line);
}

/* Clean-up */
proc.destroy();
System.out.println("Process ended !");