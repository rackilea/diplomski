@Data
@Accessors(chain = true)
@JsonInclude(Include.NON_NULL)
public class TestPOJO {

  private Long id;
  private String name;
  @JsonDeserialize(using = JsonNodeDeserializer.class)
  private JsonNode jsonNode;

  // getters and setters
}