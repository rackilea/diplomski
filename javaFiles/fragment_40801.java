BufferedReader br=null;
BufferedWriter bw=null;

try {
    File file = new File("csv file path");
    File newfile = new File("new output csv file path");

    br = new BufferedReader(new InputStreamReader(new FileInputStream(file))) ;
    bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newfile)));

    String line = null;

    while((line = br.readLine())!=null){
        String addedColumn = "\t"+"newstring";
        bw.write(line+addedColumn+System.lineSeparator());
    }
} catch(Exception e){
    System.out.println(e);
} finally  {
    br.close();
    bw.close();
}