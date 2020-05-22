package forum8334195;

import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Foo {
    int bar;

    public int getBar() {
        return this.bar;
    }

    public void setBar(Integer bar) {
        this.bar = bar.intValue();
    }

    /**
     * Put logic to update domain object based on bar field here.  This method
     * will be called after the Foo object has been built from XML.
     */
    private void afterUnmarshal(Unmarshaller unmarshaller, Object parent) {
         System.out.println(bar);
    }

}