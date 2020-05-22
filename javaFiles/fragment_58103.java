package blog.joda;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.joda.time.Interval;

@XmlRootElement
public class Root {

    private Interval interval;

    @XmlJavaTypeAdapter(IntervalStringAdapter.class)
    public Interval getInterval() {
        return interval;
    }

    public void setInterval(Interval interval) {
        this.interval = interval;
    }

}