public String readFileToString(String pathToFile) throws Exception{
    StringBuilder strFile = new StringBuilder();
    BufferedReader reader = new BufferedReader(new FileReader(pathToFile));
    char[] buffer = new char[512];
    int num = 0;
    while((num = reader.read(buffer)) != -1){
        String current = String.valueOf(buffer, 0, num);
        strFile.append(current);
        buffer = new char[512];
    }
    reader.close();
    return strFile.toString();
}