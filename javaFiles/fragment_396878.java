File file = new File("input_file.txt");
BufferedReader reader = new BufferedReader(new FileReader(file));
StringBuffer buffer = new StringBuffer();
String line;
while((line = reader.readLine()) != null) {
    buffer.append(line);
    buffer.append("\r\n");
}
reader.close();

Map<String, String> replacementMap = new HashMap<String, String>();
replacementMap.put("STRING1", "TEXT1");
replacementMap.put("STRING2", "TEXT2");
replacementMap.put("STRING3", "TEXT3");

String toWrite = buffer.toString();
for (Map.Entry<String, String> entry : replacementMap.entrySet()) {
    toWrite = toWrite.replaceAll(entry.getKey(), entry.getValue()));
}

FileWriter writer = new FileWriter("output_file.txt");
writer.write(toWrite);
writer.close();