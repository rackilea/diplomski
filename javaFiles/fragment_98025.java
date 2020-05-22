String jsflPath = "/var/...tmp/sample.jsfl";    
File jsflFile = new File(jsflPath);
jsflFile.setExecutable(true);
String[] commands = new String[]{"open", jsflFile.getAbsolutePath() };

ProcessBuilder pb = new ProcessBuilder(commands);
pb.start();