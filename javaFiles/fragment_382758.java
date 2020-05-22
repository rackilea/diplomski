externalHttpCall(convertToByteArray(items);

public byte[] convertToByteArray(List<MyBean> items){
  try (var output = new ByteArrayOutputStream();
       var printer = new CSVPrinter(new OutputStreamWriter(output), CSVFormat.DEFAULT)) {
    printer.printRecord(EMAIL);
    for (MyBean mb : items) {
      printer.printRecord(mb.getEmail());
    }
    printer.flush()
    log.info("Printer was flushed");

    return output.toByteArray();
  }
}