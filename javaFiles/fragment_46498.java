ProcessBuilder pb = new ProcessBuilder("myshellScript.sh", "myArg1", "myArg2");
Map<String, String> env = pb.environment();
env.put("VAR1", "myValue");
env.remove("OTHERVAR");
env.put("VAR2", env.get("VAR1") + "suffix");
pb.directory("myDir");
Process p = pb.start();
InputStream is = p.getInputStream();
// use process p's input stream is to provide input to your process here
OutputStream os = p.getOutputStream();
// use process p's output stream to get the results here