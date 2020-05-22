Process newExec = null;
BufferedReader outStream = null;
BufferedReader inStream = null;
BufferedReader errStream = null;

StringBuffer outputBuffer = new StringBuffer();

String PATH_TO_EXEC = config.getExecPath();

try {
    newExec = Runtime.getRuntime().exec(PATH_TO_EXEC + " " +  args);
    PrintWriter o = new PrintWriter(newExec.getOutoutStream());
    o.println("input to process");
    o.flush();
}
catch(IOException e){
    outputBuffer.append("Error in running executable.");
    e.printStackTrace();
    return outputBuffer.toString();
}