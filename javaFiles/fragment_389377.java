package forum9610190;

import javax.xml.bind.annotation.XmlTransient;
import org.joda.time.DateTime;

public class Root {

    @XmlTransient
    private DateTime startTime;

    public DateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(DateTime startTime) {
        this.startTime = startTime;
    }

}