final BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(p.getOutputStream()));
    while(true){
        String newLine = "\n\r";
        writer.write(newLine);
    }