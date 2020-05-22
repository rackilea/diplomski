BufferedWriter writer = new BufferedWriter(new FileWriter("myfile"));
 writer.append(oneString);
 writer.append(oneStringBuffer);
 writer.newLine();

 BufferedReader reader = new BufferedReader(new FileReader("myfile"));
 String currentLine = reader.readLine();