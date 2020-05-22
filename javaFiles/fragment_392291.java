public static void main(String[] args) throws Exception{

try {
    FileReader reader = new FileReader("/Users/mohammed/Downloads/testFile.txt");
    BufferedReader bufferedReader = new BufferedReader(reader);
    String username="mohammed";
    String line = new String();

    while ((line = bufferedReader.readLine()) != null) 
        if(line.equals(username){
            System.out.println(bufferedReader.readLine());
            break;
        }

    reader.close();

} catch (IOException e) {
    e.printStackTrace();
}
}