public static void main(String[] args) throws IOException, InterruptedException {
    printSystemProperties();
    System.out.println();
    printEnvironment();
    String[] command = new String[ args.length - 1 ];
    System.arraycopy(args, 1, command, 0, args.length-1);
    ProcessBuilder processBuilder = new ProcessBuilder( Arrays.asList(command));
    Map<String, String> env = processBuilder.environment();
    env.put("LIBPATH", args[0] );
    Process process = processBuilder.start();
    new StreamReader("OUT  ", process.getInputStream() ).start();
    new StreamReader("ERROR", process.getErrorStream() ).start();
    process.waitFor();
}