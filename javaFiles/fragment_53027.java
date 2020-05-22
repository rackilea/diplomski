BufferedReader reader = new BufferedReader(new FileReader("yourfile.txt"));
List<String> list = new ArrayList<>();
String line=null;
while((line= reader.readLine())!=null) {
list.add(line);
}