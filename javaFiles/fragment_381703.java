public static void main(String[] args) throws IOException {
    File path=new File("D:\\FileSource");
    File[] listOfFiles = path.listFiles();
    BufferedWriter bw=new BufferedWriter(new FileWriter("D:\\DestFile\\outPut.txt"));
    String s=new String();
    for (int i = 0; i < listOfFiles.length; i++) {
        File file = listOfFiles[i];
        if (file.isFile() && file.getName().endsWith(".txt")) {
            BufferedReader br=new BufferedReader(new FileReader(file));
            while ((s=br.readLine())!=null){
                bw.write(s);
            }
        }
    }
   bw.close();
 }