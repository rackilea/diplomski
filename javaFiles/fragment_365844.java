String line = tableLines[i].toString().trim();
String[] dataRow = line.split("/");
int dataRowLength = dataRow.length;
Integer[] dataRowIntegers = new Integer[dataRowLength];
for(int i = 0; i < dataRowLength; i++){
    dataRowIntegers[i] = Integer.valueOf(dataRow[i]);
}
model.addRow(dataRowIntegers);