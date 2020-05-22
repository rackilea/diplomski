@JacksonXmlRootElement(localName = "breakfast_menu")
public class BreakfestFood {

    // Use this to change element name:
    // @JacksonXmlProperty(localName = "food")
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Food> food;

    // getters and setters
}