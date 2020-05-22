import org.apache.axis.wsdl.WSDL2Java;

public class Random {

    public static void main(String[] args) {
        String[] params = new String[] {"-v", "-D", "-o c:/projects/WSTest", "http://URL to WSDL file"};  
        try  {  
            WSDL2Java.main(params);  
        } catch (Exception ex) {  
            ex.printStackTrace()  
        }  
    }
}