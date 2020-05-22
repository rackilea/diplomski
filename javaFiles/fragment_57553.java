public class JavaTutorialsCornerWeb {         
    public void testMethodnew() {
        try {
            JavaTutorialsCorner jtc = new JavaTutorialsCorner();
            jtc.testMethod();        
        } catch (SampleException sx) {
            sx.printStackTrace();
        } 
    } 
}