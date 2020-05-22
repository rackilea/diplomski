public void saveContent() throws Exception {
   String choosenCode = getChoosenCode(book);
   book.setChoosen(choosenCode);
}

static String getChoosenCode(Book book) throws Exception {
   if (book.isColored()) {
      return “1234”;
   }
   if (book.isAvailable()) {
      return “23498”;
   }
   if (book.isAdults()) {
      return “0562”;
   }
   ReaderResponse response = reader.getReaderResponse();
   return (response != null) 
      ? response.getName()
      : “4587”;
}