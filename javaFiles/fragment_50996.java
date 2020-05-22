package forum13872065;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.datatype.*;

public class GMonthAdapter extends XmlAdapter<String, XMLGregorianCalendar> {

    DatatypeFactory dtf;

    public GMonthAdapter() {
         try {
            dtf = DatatypeFactory.newInstance();
        } catch (DatatypeConfigurationException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public XMLGregorianCalendar unmarshal(String v) throws Exception {
        return dtf.newXMLGregorianCalendar(v);
    }

    @Override
    public String marshal(XMLGregorianCalendar v) throws Exception {
        String string = v.toXMLFormat();
        if(string.endsWith("--")) {
            return string.substring(0,4);
        }
        return string;
    }

}