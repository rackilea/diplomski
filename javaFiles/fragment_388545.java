@XmlRootElement
@XmlSeeAlso({Tag2V1.class, Tag2V2.class})
abstract class Tag2 {

    private String name;
    private String content;

    @XmlAttribute(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlValue
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}

@XmlRootElement(name = "tag_2_v1")
class Tag2V1 extends Tag2 {

    private String id;

    @XmlAttribute(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}

@XmlRootElement(name = "tag_2_v2")
class Tag2V2 extends Tag2 {

    private String specialId2;

    @XmlAttribute(name = "special_id_2")
    public String getSpecialId2() {
        return specialId2;
    }

    public void setSpecialId2(String specialId2) {
        this.specialId2 = specialId2;
    }

}