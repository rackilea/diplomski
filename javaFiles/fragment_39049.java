ProcessBuilder pb =
   new ProcessBuilder("myCommand", "myArg1", "myArg2");
 Map<String, String> env = pb.environment();
 env.put("VAR1", "myValue");
 env.remove("OTHERVAR");
 env.put("VAR2", env.get("VAR1") + "suffix");
 pb.directory(new File("myDir"));
 File log = new File("log");
 pb.redirectErrorStream(true);
 pb.redirectOutput(Redirect.appendTo(log));
 Process p = pb.start();
 assert pb.redirectInput() == Redirect.PIPE;
 assert pb.redirectOutput().file() == log;
 assert p.getInputStream().read() == -1;