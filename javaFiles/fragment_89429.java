@XmlAccessorType(XmlAccessType.FIELD)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonTypeName("ZooAnimals")
class ZooAnimals {

    @XmlAttribute
    @JsonProperty("@size")
    private String size;

    @XmlElement(name = "Animal", required = false)
    private List<Animal> animalList;

    @JsonAnySetter
    public void setAny(String propertyName, Map<String, Animal> map) {
        animalList = new ArrayList<Animal>(map.values());
    }

    // getters, setters, toString
}