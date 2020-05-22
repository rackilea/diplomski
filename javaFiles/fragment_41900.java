final SynchronousQueue<String> wikiLines = new SynchronousQueue<>();

Thread fetchXmlThread = new Thread(() -> {
    while ((sCurrentId = inputFile.readLine()) != null) {
        counterLine++;
        WikiLine wikiLine = download(sCurrentId,counterLine);
        if (wikiLine != null)
             wikiLines.put(wikiLine.toString());
    }
});

Thread writeToFileThread = new Thread(() -> {
    for(;;) {
        outputFile.append(wikiLines.take());
    }
});

fetchXmlThread.start();
writeToFileThread.start();