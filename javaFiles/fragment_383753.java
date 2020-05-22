@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class SomeElement {

    @XmlAttribute
    private String a;

    @XmlAttribute
    private String b;

    @XmlJavaTypeAdapter(NumberAndScaleAdapter.class)
    @XmlPath(".")
    private FOO numberAndScale;

    private Child child;

}