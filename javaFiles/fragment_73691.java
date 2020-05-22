String appDir = "C:\\my\\full\\path\\to\\script.py";
ProcessBuilder pb = 
   new ProcessBuilder("python", appDir);

Process p = pb.start();
....