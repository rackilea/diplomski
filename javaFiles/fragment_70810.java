ProcessBuilder pb = new ProcessBuilder("myCommand", "myArg1", "myArg2");
 Map<String, String> env = pb.environment();
 env.put("VAR1", "myValue");
 env.remove("OTHERVAR");
 env.put("VAR2", env.get("VAR1") + "suffix");
 pb.directory("myDir");
 Process p = pb.start();