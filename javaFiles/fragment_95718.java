@JsonSerialize(converter = ContainerToMap.class)
public class ContainerWithFieldData {
    private final Map<SomeKey, Object> data;

    public ContainerWithFieldData(Map<SomeKey, Object> data) {
        this.data = data;
    }
}

public static final class SomeKey {
    public final String key;

    public SomeKey(String key) {
        this.key = key;
    }

    @JsonValue
    public String toJsonValue() {
        return "key:" + key;
    }

    @Override
    public String toString() {
        return "SomeKey:" + key;
    }
}

public static final class ContainerToMap extends StdConverter<ContainerWithFieldData, Map<SomeKey, Object>> {
    @Override
    public Map<SomeKey, Object> convert(ContainerWithFieldData value) {
        return value.data;
    }
}

@Test
public void serialize_container_with_custom_keys_in_field_map() throws Exception {
    ObjectMapper mapper = new ObjectMapper();
    assertThat(
            mapper.writeValueAsString(new ContainerWithFieldData(ImmutableMap.of(new SomeKey("key1"), "value1"))),
            equivalentTo("{ 'key:key1' : 'value1' }"));
}