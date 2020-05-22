File sysRoot = new File(System.getenv("systemroot"));
File ipconfig = new File(new File(sysRoot, "system32"), "ipconfig");
String[] command = new String[] { ipconfig.getAbsolutePath(), "/all" };
Process p = Runtime.getRuntime().exec(command);
BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
// read all output from br, then p.waitFor()