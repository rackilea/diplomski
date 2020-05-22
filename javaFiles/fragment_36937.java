@Data
@XmlRootElement(name="root")
@XmlAccessorType(XmlAccessType.FIELD)
public class rootClass
{
    @XmlJavaTypeAdapter(EnumAdapter .class)
    @XmlElement(name="test")
    public FeFiFo test;
}