public void convert(File output, File...input) {

   List<Record> records = new ArrayList<Record>();
   for (File file:input) {
     if (input.isThreeColumnFormat()) {
        records.addAll(ThreeColumnFormatParser.parse(file));
     } else {
        records.addAll(FourColumnFormatParser.parse(file));
     }
   }
   CsvWriter.write(output, records);
 }