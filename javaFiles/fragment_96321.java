import javax.xml.bind.annotation.adapters.XmlAdapter;

public class ColorAdapter extends XmlAdapter<String, String> {

    @Override
    public String unmarshal(String v) throws Exception {
        return System.getProperty(v);
    }

    @Override
    public String marshal(String v) throws Exception {
        return v;
    }

}