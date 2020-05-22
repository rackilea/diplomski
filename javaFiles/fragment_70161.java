List commands = new java.util.ArrayList<String>();
commands.add("python");
commands.add("-m");
commands.add("test");//test.py in test.zip
ProcessBuilder pb = new ProcessBuilder();
pb.command(commands);
Map workerEnv = pb.environment();
workerEnv.put("PYTHONPATH", "/path/to/test.zip");
Process worker = pb.start();