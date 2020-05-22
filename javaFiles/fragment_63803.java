InputSupplier<? extends InputStream> supplier = ...
InputSupplier<InputStreamReader> readerSupplier = 
    CharStreams.newReaderSupplier(supplier, Charsets.UTF_8);

// InputStream and Reader are both created and closed in this single call
String text = CharStreams.toString(readerSupplier);