protected void executeWrite(PrintWriter out, ReadWriteLock readWriteLock, Transformer transformer)
        throws HandledException {

    Lock readLock = readWriteLock.readLock();
    StringWriter outWriter = new StringWriter();
    Transformer t = null;
    try {
        readLock.lock();
        StreamSource xmlStream = new StreamSource(/*path to XML*/);
        t = transformer;
        t.transform(xmlStream, new StreamResult(outWriter));
    } catch (TransformerException e) {
        ExceptionHandler.logAndThrow(e, logger);
    } finally {
        readLock.unlock();
    }

    Lock writeLock = readWriteLock.writeLock();
    FileWriter fileWriter = null;
    try {
        writeLock.lock();
        fileWriter = new FileWriter(new File(/*path to XML*/));
        fileWriter.write(outWriter.toString());
    } catch (IOException e) {
        ExceptionHandler.logAndThrow(e, logger);
    } finally {
        if (fileWriter != null) {
            try {
                fileWriter.close();
            } catch (IOException e) {
                ExceptionHandler.logAndThrow(e, logger);
            }
        }
        writeLock.unlock();
    }
}