@Data
@NoArgsConstructor
@AllArgsConstructor
public class Test {

    private String name;
    private Map<String, String> properties;

    @JsonAnySetter
    public void add(String key, String value) {
       properties.put(key, value);
     }

}