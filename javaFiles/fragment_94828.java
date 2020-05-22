CSVReader reader = new CSVReader(new FileReader(csvFilename), ';', '\'', 1);

int rowCount = 2;                                    // save last 2 lines
Buffer<String[]> savedBuffer = new CircularFifoBuffer<String[]>(rowCount); 
String[] nextLine;
while ((nextLine = reader.readNext()) != null) {
   savedBuffer.add(nextLine);
}

int columnIndex = 2; // zero based
System.out.println(savedBuffer.get()[columnIndex]);