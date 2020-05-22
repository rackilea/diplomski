List<String> lines = new ArrayList<>();
String line = bufferedReader.readLine();
while(line != null){
   lines.add(line);
   line = bufferedReader.readLine();
}
bufferedReader.close();