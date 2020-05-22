CSVWriter writer = new CSVWriter(new FileWriter("yourfile.csv"), '\t');
 ...
 String[] row = new String[];
 int i=0;
 while(keys.hasNext()) {
     row[i++] = keys.next().getCount();
 }
 writer.writeNext(entries);