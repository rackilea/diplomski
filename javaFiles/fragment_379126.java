final DomXmlParser parser = new DomXmlParser(xmlUrl);

Thread thread = new Thread(new Runnable() {
    @Override
    public void run() {
        parser.getXML();
    }
});
thread.start();
try {
    thread.join();  // wait until above thread finishes
} catch (InterruptedException e) {
    // handle the exception here
}
doc = parser.getDoc();