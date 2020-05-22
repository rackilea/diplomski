@JacksonXmlRootElement(localName = "main")
@Data
public class RequestVO implements Serializable {
    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "level")
    ArrayList<LevelVO> levelList;
}


@JacksonXmlRootElement(localName = "level")
@Data
public class LevelVO implements Serializable {
    @JacksonXmlProperty(localName = "id", isAttribute = true)
    String id;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "my")
    ArrayList<MyVO> myList;
}

@JacksonXmlRootElement(localName = "my")
@Data
public class MyVO implements Serializable {
    @JacksonXmlProperty(localName = "id", isAttribute = true)
    String id;

    @JacksonXmlProperty(localName = "amount", isAttribute = true)
    String amount;
}