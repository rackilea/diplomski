@XmlAccessorType(XmlAccessType.FIELD)
public class Outcome {

    @XmlElement(name="measure")
    private String measure;

    @XmlElement(name="time_frame")
    private String timeFrame;

    @XmlElement(name="safety_issue")
    private String safetyIssue;

    @XmlElement(name="description")
    private String description;

    // getters and setters omitted for brevity
}