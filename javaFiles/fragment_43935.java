BufferedReader csvFile = new BufferedReader(new FileReader(new File(path)));
String line = "start";
int count = 0;
while((line = csvFile.readLine()) != null){
    System.out.println(line);
}   
csvFile.close();