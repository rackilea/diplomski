String headerLine = csvReader.readNext();

List numbersInHeader = new ArrayList();
for(int i = 0 ; i < headerLine.length ; i++){
    if(headerLine[i].equals("YouHeaderNameHere") || headerLine[i].equals("OtherNumberHeader")){
        numberInHeader.add(i);
    } 
}
String line[] = null;
while((line = csvReader.readNext()) != null){
    for(int i = 0 ; i < line.length ; i++){
        if(numbersInHeader.contains(i)){ 
            // This is a number do you work here

        }

    }
}