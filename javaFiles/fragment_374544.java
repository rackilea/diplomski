package forum7182533;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class Adapter1
    extends XmlAdapter<String, Integer>
{


    public Integer unmarshal(String value) {
        return (forum7182533.NumberFormatter.parseInt(value));
    }

    public String marshal(Integer value) {
        return (forum7182533.NumberFormatter.printInt(value));
    }

}