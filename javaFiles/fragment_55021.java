String endOfLineToken = "..."; //your variant
    String[] lines = finalDataA[0].split(endOfLineToken)
    BufferdWriter bw = new BufferedWriter(new FileWriter(pathA, true));
    try 
    {
       for (String line: lines)
       {
           bw.write(line);
           bw.write(endOfLineToken);//to put back line endings
           bw.newLine();
           bw.flush();
       }
    }
    catch (Exception e) {}