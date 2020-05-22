import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, Date>{

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Date unmarshal(String v) throws Exception {
        if(v.length() == 0) {
            return null;
        }
        return dateFormat.parse(v);
    }

    @Override
    public String marshal(Date v) throws Exception {
        if(null == v) {
            return null;
        }
        return dateFormat.format(v);
    }

}