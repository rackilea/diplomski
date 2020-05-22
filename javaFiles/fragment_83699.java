@RequestMapping(method = RequestMethod.GET,value = "/createFOO",produces = "application/xml")
public void createFOO(OutputStream out){
    try (InputStream is = new FileInputStream("largeXmlGraph.xml")) {
        StreamUtils.copy(is, out);
    } catch (IOException e) {
        e.printStackTrace();
    }
}