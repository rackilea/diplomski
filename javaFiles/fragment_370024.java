package forum13122968;

import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Publication {

    Date date;
    int year;

    private void afterUnmarshal(Unmarshaller unmarshaller, Object parent) {
        year = date.getYear();
    }

}