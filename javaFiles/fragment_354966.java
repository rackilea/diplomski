public static void main (String[] args)throws IOException{
    String filename = "data/raw.txt";
    Scanner fr=new Scanner(new FileReader(filename));
    //reads the line and passes it to another method where it is put into a list
    String line;
    while(fr.hasNextLine()){
        line=fr.nextLine();
        List namenum=readM(line);
        dataProcess(namenum);
    }
    fr.close();        
}

public static List readM(String line)throws IOException{
    Scanner scn=new Scanner(line);
    List<String>namenum=new ArrayList<String>();
    while(scn.hasNext()){
        namenum.add(scn.next());
    }
    Collections.sort(namenum,Collections.reverseOrder());
    return namenum;
}