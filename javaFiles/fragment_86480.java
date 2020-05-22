@Data
@NoArgsConstructor
@AllArgsConstructor
public class Test {

    private String name;
    private List<Integer> properties;

    @JsonAnySetter
    public void add(String key, Integer value) {
       properties.add(value);
     }

}