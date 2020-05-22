String line = reader.readLine();
while(line != null){
    stringArray.add(line);
    line = reader.readLine(); // read the next line
}
return stringArray;