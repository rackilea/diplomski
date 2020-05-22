@Override
public void configure() throws Exception {
    errorHandler(loggingErrorHandler(logger));
    from("sftp://XXX@safsdf.de/dir/?delay=2s&move=${in.header.outDirectory}&moveFailed=failImport")
            .process(exchange -> exchange.setProperty(originalMessage, exchange.getIn()))
            .split()
            .body()
            .process(e -> {
                String fileName = (String) e.getIn().getHeader(Exchange.FILE_NAME);
                Message origMsg = (Message) e.getProperty(originalMessage);
                try {
                    // do what ever
                    origMsg.setHeader(outDirectory, "done/" + fileName);
                } catch (KaboomException ex) {
                    origMsg.setHeader(outDirectory, "retry/" + fileName);
                }
            })
            .log("Imported file ${file:name} completely.");

}