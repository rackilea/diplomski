public class CustomMapper extends ObjectMapper {

public CustomMapper() {
    super();
    this.registerModule(new JtsModule());
}
}