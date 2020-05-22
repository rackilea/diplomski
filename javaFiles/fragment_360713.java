boolean empty = (new File(OUTPUT_CSV_FILE_PATH)).length() == 0;
if(!empty){
    csvDocumentDetailIterator = csvToBean4Output.iterator();
    while (csvDocumentDetailIterator.hasNext()) {
        DocumentDetail documentDetail = csvDocumentDetailIterator.next();
        logger.info(documentDetail);
        boolean isSent = commonMethods.uploadDoc(documentDetail);
        logger.info("isSent: " + isSent);
        if(!isSent){
            documentDetailsNotSent.add(documentDetail);
        }
    }
}