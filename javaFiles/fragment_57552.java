public class JavaTutorialsCorner {     
    public void testMethod() throws SampleException { 
        try {
            // some logic
        } catch (IOException e) {
            throw new SampleException("Other IOException", e); 
        } 
    } 
}