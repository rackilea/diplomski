@Entity
@XmlRootElement
public class test {
    @Getter
    @Setter
    @XmlElement(name = "country")
    @XmlJavaTypeAdapter(CountryXmlAdapter.class)
    private Country country
}