@XmlRootElement(name = "measureTypes")
public class MessageDefinitionResult {

    @XmlElement(name = "measureType")
    @XmlJavaTypeAdapter(MeasureDefinitionXmlAdapter.class)
    private List<MeasureDefinition> measureDefinitions;

    public MessageDefinitionResult(final List<MeasureDefinition> measureDefinitions) {
        this.measureDefinitions = measureDefinitions;
    }

    public MessageDefinitionResult() { }

    public List<MeasureDefinition> getMeasureDefinitions() {
        return measureDefinitions;
    }

    public static final class MeasureDefinitionXmlAdapter extends XmlAdapter<String, MeasureDefinition> {

        @Override
        public MeasureDefinition unmarshal(final String v) throws Exception {
            return null; // or whatever
        }

        @Override
        public String marshal(final MeasureDefinition v) throws Exception {
            return v.getName();
        }
    }

}