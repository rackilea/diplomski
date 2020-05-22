package forum10566766;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Article {

    private License license;

    public License getLicense() {
        return license;
    }

    public void setLicense(License license) {
        this.license = license;
    }

}