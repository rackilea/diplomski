public void execute(InputStream sourceFile, OutputStream targetFile) //throws StreamTransformationException
{       
    BufferedReader reader;
    OutputStreamWriter writer;
    try{    

        // creating the parser object 
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        String line = "<Tax>";
        String line1 = "</Tax>";
        String currentLine;
        reader = new BufferedReader(new InputStreamReader(sourceFile));
        writer =new OutputStreamWriter(targetFile);

        dbFactory.setNamespaceAware(true);
        while ( (currentLine = reader.readLine() ) != null){
              String trimmedLine = currentLine.trim();
              if(trimmedLine.equals(line) || trimmedLine.equals(line1) ) continue;
              writer.write(currentLine + System.getProperty("line.separator"));
        }

        reader.close();
        writer.close();
    } catch (Exception e) { 
        e.printStackTrace();    
    }   
}