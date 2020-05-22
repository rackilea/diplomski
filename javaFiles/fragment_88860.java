File file = new File("my_file.txt");
BufferedReader reader = new BufferedReader(new FileReader(file));
FileWriter writer = new FileWriter("my_out_file.txt");
String line = "";
while((line = reader.readLine()) != null) {
    // Replacing "AAAA" strings
    String newtext= line.replaceAll("AAAA", "BBBB");    
    writer.write(newtext);
}
reader.close();
writer.close();