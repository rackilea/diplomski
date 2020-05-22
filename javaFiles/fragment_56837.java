public static List<String> readFile(int n) throws IOException {
    try(BufferedReader br = new BufferedReader(new 
FileReader("C:\\\\\\\\Users\\\\\\\\Admin\\\\\\\\Desktop\\\\\\\\Work Files\\\\\\\\314- 
WO0000001133814\\\\\\\\Cards\\\\\\\\MBD10760_182.out"))){
        List<String> listOfData = new ArrayList<>();
        String d;
        while((d = br.readLine()) != null && n>0){
            listOfData.add(d);
            n--;
        }
        return listOfData;
    }