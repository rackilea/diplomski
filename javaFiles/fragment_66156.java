package forum9629948;

import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class IDAdapter extends XmlAdapter<String, Long> {

    @Override
    public Long unmarshal(String string) throws Exception {
        return DatatypeConverter.parseLong(string);
    }

    @Override
    public String marshal(Long value) throws Exception {
        return DatatypeConverter.printLong(value);
    }

}