private static final String json ="{\n" +
        "    \"externalLinks\": [\"link1\", \"link2\"],\n" +
        "    \"lectureRequirements\": [\"requirement1\", \"requirement2\"]\n" +
        "}";

public static void main(String[] args) throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    Lecture l = mapper.readValue(json,Lecture.class);
    System.out.println(mapper.writeValueAsString(l));

}

public static class Lecture {
    @JsonProperty("externalLinks")
    private List<LectureExternalLink> lectureExternalLinks;

    @JsonProperty("lectureRequirements")
    private List<LectureRequirement> lectureRequirements;

    public List<LectureExternalLink> getLectureExternalLinks() {
        return lectureExternalLinks;
    }

    public void setLectureExternalLinks(List<LectureExternalLink> lectureExternalLinks) {
        this.lectureExternalLinks = lectureExternalLinks;
    }

    public List<LectureRequirement> getLectureRequirements() {
        return lectureRequirements;
    }

    public void setLectureRequirements(List<LectureRequirement> lectureRequirements) {
        this.lectureRequirements = lectureRequirements;
    }
}

@JsonFormat(shape = JsonFormat.Shape.STRING)
private static class LectureRequirement {
    private String name;

    private Integer id;

    public LectureRequirement(String name) {
        this.name = name;
    }
    @JsonValue
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}


@JsonDeserialize(using = MyJsonDeserializer.class)
public static class LectureExternalLink {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

private static class MyJsonDeserializer extends JsonDeserializer<LectureExternalLink> {

    @Override
    public LectureExternalLink deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String value = p.getValueAsString();
        LectureExternalLink val= new LectureExternalLink();
        val.setName(value);
        return val;
    }
}