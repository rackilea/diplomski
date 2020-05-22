@Test
public void mixin_to_specify_creator() throws Exception {
    TargetData target = mapper.addMixIn(TargetData.class, TargetDataMixin.class).reader(TargetData.class)
            .<TargetData> readValue("{\"name\":\"the name\", \"description\":\"the description\"}");
    assertThat(target.name, equalTo("the name"));
    assertThat(target.description, equalTo("the description"));
}

public static class TargetData {
    private final String name;
    private final String description;

    public TargetData(String name, String description) {
        this.name = name;
        this.description = description;
    }
}

public static abstract class TargetDataMixin {
    @JsonCreator
    public TargetDataMixin(@JsonProperty("name") String name, @JsonProperty("description") String description) {
    }
}