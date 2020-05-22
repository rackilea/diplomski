CountDownLatch latch = new CountDownLatch(numberOfFilesInDirectory);

directory.listFiles().each { eachFile ->
   service.submit(new FileReader(eachFile, param2))
}

latch.await();


// And in your Callable:
class FileReader implements Callable {
File file
String param
FileReader(File file, String param){
    this.file = file
    this.param = param
}

public Object call() {
    try {
    LOG.info("Processing file" + filePath)
    ConfigInfo configInfo = new ConfigInfo()
    configInfo.setFilePath(filePath);
    configInfo.setReaderUid(readerUid);
    configInfo.setPatternsMap(patternsMap);
    new LogfileDataProcessor(configObject, param).processFileContent();
    } finally {
        latch .countDown();
    }
}