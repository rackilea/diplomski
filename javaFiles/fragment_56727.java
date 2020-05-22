FMSParser fmsParser = new FMSParser();
while (messageIterator.hasNext()) {
   String msg = messageIterator.next();
   if (fmsParser.isValid(msg)) {
       params = fmsParser.getParam(msg);
   }
}