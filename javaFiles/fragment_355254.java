// NwInterface.java
import java.util.ArrayList;

public class NwInterface {    

    public native ArrayList<String> getAddresses(String adapterName);    

    static
    {
        System.loadLibrary("nwinterface");
    }        
}