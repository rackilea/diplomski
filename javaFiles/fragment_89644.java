//... your code here
ZipEntry entry = zip.getEntry(file);
InputStream in = zip.getInputStream(entry);

if(in.read() == 239 & in.read() == 187 & in.read() == 191){
    System.out.println("UTF-8 with BOM, bytes discarded");
}

CsvParserSettings parserSettings = new CsvParserSettings();
//...rest of your code here