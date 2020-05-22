@XmlRootElement(name="clinical_study")
@XmlAccessorType(XmlAccessType.FIELD)
public class ClinicalStudy {

    @XmlElement(name="primary_outcome")
    private Outcome primaryOutcome;

    @XmlElement(name="secondary_outcome")
    private Outcome secondaryOutcome;

    // getters and setters omitted for brevity
}