// New BufferedReader.
BufferedReader reader = new BufferedReader(new FileReader(file));

// Add all lines from file to ArrayList.
while (true){
    String line = reader.readLine();
    if(line==null){
        break;
    }
    lineList.add(line);
}

// Close it.
reader.close();

StringBuilder sb = new StringBuilder();

// Print each line.
for (String line : lineList){
    sb.append(line);
}

// SetText method from the JavaMail API that does not accept the for-loop  
message.setText(sb.toString());