File file = new File("file.csv");
FileInputStream fis = null;
String dataStr = "";
try {
    fis = new FileInputStream(file);
    int content;
    while ((content = fis.read()) != -1) {
        dataStr += (char) content;
    }
} catch (IOException e) {
    e.printStackTrace();
}
// convert to array rows string
String[] dataRows = dataStr.split("\n");

// loop rows to get cells string
for (int i = 0; i < dataRows.length; i++) {
    String[] dataCells = rowData[i].split(",");
    //do what ever you want with dataCells
}