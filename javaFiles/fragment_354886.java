import java.io.InputStream;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@XmlRootElement(name = "authStore")
@XmlAccessorType(XmlAccesssType.FIELD)
public class AuthStore {
    public static void main(String []args) throws Exception {
        InputStream inputStream = AuthStore.class.getResourceAsStream("test.xml");
        JAXBContext jaxbContext = JAXBContext.newInstance(AuthStore.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        AuthStore authStore = (AuthStore)unmarshaller.unmarshal(inputStream);

        System.out.println(authStore.getAuthList().get(0).getResource());
        System.out.println(authStore.getAuthList().get(0).getPrivilege().getRegex());
        System.out.println(authStore.getAuthList().get(0).getPrivilege().getValue());
    }

    @XmlElementWrapper(name = "authList")
    @XmlElement(name = "auth")
    private List<Auth> authList;

    public List<Auth> getAuthList() {
        return authList;
    }

    @XmlAccessorType(XmlAccesssType.FIELD)
    public static class Auth {
        @XmlElement(name = "resource")
        private String resource;
        @XmlElement(name = "privilege")
        private Privilege privilege;

        public String getResource() {
            return resource;
        }

        public Privilege getPrivilege() {
            return privilege;
        }

        @XmlAccessorType(XmlAccesssType.FIELD)
            public static class Privilege {
            @XmlAttribute(name = "regex")
            private Boolean regex;
            @XmlValue
            private String value;

            public Boolean getRegex() {
                return regex;
            }

            public String getValue() {
                return value;
            }
        }
    }
}