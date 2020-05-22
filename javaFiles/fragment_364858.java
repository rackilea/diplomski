File file = new File("H:\whatever.txt");

// Write to the file
FileWriter fw = new FileWriter(file);
fw.write("your path goes here");
fw.close();

// Read from the file
BufferedReader br = new BufferedReader(new FileReader(file));
String path = br.readLine();
br.close();