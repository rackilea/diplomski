List<String> fileData = new ArrayList<>();
String line;
BufferedReader reader=new BufferedReader(new FileReader(file));
while ( (line = reader.readLine()) != null) {
    if (line.charAt(0) != '#') {
        fileData.add(line);
    }
}
reader.close();
//use the content of fileData to parse your file as expected