String inputString = "name: date, order: 1, required: true, type: date, placeholder: Expense Date";
StringBuilder validJson = new StringBuilder();
validJson.append("{");
String[] lineByLine =  inputString.split(",");
for(int i =0; i< lineByLine.length; i++){
    String[] lineSplit = lineByLine[i].split(":");
    validJson.append('"').append(lineSplit[0].trim()).append('"').append(":").append('"').append(lineSplit[1].trim()).append('"').append(i==lineByLine.length-1?"}":",");
}
String finishedJSON = validJson.toString();
System.out.println(finishedJSON);