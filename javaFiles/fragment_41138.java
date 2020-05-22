BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\NormenYu\\Desktop\\Programming\\Java\\eclipse\\Book\\"+thebook+".txt"));
String line;

while((line = reader.readLine()) != null) {
  System.out.println(line);
}
reader.close()