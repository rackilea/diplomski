static String workingDir = System.getProperty("user.dir");
public static void main(String[] args){

    Properties p = getProps(workingDir+"path/to/names.txt",workingDir+"path/to/numbers.txt");
    File output = new File(workingDir+"path/to/output.txt");

    try {
        PrintStream ps = new PrintStream(output);
        BufferedReader tbx = new BufferedReader(new InputStreamReader (new FileInputStream(new File(workingDir+"path/to/the.tbx"))));
        String currentLine;
        String theNum;
        String theName;
        int c; //temp index
        int start;
        int end;
        while((currentLine = tbx.readLine()) != null){
            if(currentLine.contains("subjectField")){
                c = currentLine.indexOf("subjectField");
                start = currentLine.indexOf(">", c)+1;
                end = currentLine.indexOf("<", c);
                theNum = currentLine.substring(start, end);
                theName = p.getProperty(theNum);
                currentLine = currentLine.substring(0,start)+theName+currentLine.substring(end);
            }
            ps.println(currentLine);            
        }
        ps.close();
        tbx.close();
    } catch (IOException e) {
        e.printStackTrace();
    }

}