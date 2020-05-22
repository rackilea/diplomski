ProcessBuilder pb = new ProcessBuilder("hostid");
 Process p = pb.start();
 BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
 String line = null;
 while ((line = reader.readLine()) != null)
 {
    // Store returned string here.
 }
 reader.close();