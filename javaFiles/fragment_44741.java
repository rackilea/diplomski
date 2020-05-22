HashMap<String, PdfObject> names = reader.getNamedDestinationFromNames();
for (Map.Entry<String, PdfObject> entry: names.entrySet()) {
    System.out.print(entry.getKey());
    System.out.print(": p");
    PdfArray arr = (PdfArray)entry.getValue();
    System.out.println(arr.getAsNumber(0).intValue() + 1);
}
reader.close();