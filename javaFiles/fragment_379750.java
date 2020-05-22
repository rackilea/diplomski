private String readFromFile(){
    String savedName="";
    try {
    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(f)));
    savedName = br.readLine();
    System.out.println(savedName);
    } catch (IOException e) {
        e.printStackTrace();
    }
    return savedName;

}