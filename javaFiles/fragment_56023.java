boolean result = false;
if(inputFile.exists())
{
    FileReader fr = null;
    BufferedReader br = null;
    try{
        fr = new FileReader(inputFile);
        br = new BufferedReader(fr);
        Stack lines = new Stack();
        String line;
        while((line = br.readLine()) != null)
        {
            lines.push(line);
        }
        br.close();
        int numberOfRecords = lines.size();
        for(int i = 0 ; i < numberOfRecords ; ++i)
        {
            String theString = (String)lines.pop();
        }
        result = true;
    }
    finally{
        if( br != null ) br.close();
        if( fr != null ) fr.close();
    }
}
return result;