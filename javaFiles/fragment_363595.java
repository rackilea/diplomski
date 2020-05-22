try {
    Process proc = Runtime.getRuntime().exec("process.exe");
    BufferedReader input = new BufferedReader(new InputStreamReader(proc.getInputStream()));
    OutputStreamWriter oStream = new OutputStreamWriter(proc.getOutputStream());
    oStream.write("process where name='process.exe'");
    String line;
    while ((line = input.readLine()) != null) { 
        if (line.contains("process.exe")) 
            return true; 
    } 
    input.close(); 
} 
catch (Exception ex) { 
    // handle error 
}