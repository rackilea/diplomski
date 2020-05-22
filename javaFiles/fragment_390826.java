ProcessBuilder pb = new ProcessBuilder("start", "\"JAwesomeSauce\"", "cmd.exe",
    "/k", javaPath + javaCommand, maxMemStr, minMemStr, stackSizeStr, jarCommand,
    jarfile, jarArg);
try {
    Process p = pb.start();
} catch (IOException ex) {
    Logger.getLogger(launch.class.getName()).log(Level.SEVERE, null, ex);
}