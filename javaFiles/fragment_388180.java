while(reader.hasNext()){
    website = reader.next();
    username = reader.next();
    password = reader.next();
    break;
} 
//similarly, you can modify the above code 
//if you can read all the inputs in one line
while (reader.hasNextLine()) {
    String[] lineArray = reader.nextLine().split("specifyDelimeterHere");
    website = lineArray[0];
    username = lineArray[1];
    password = lineArray[2];
    break;
}