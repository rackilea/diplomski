package forum10566766;

import javax.xml.bind.annotation.XmlAttribute;

public class License {

    private String href;

    @XmlAttribute(namespace="http://www.w3.org/1999/xlink")
    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

}