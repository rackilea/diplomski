@GraphQLQuery(name = "renderUI", description = "Schema for your form")
public Map<String, Object> renderUI() {
    Map<String, Object> dynamic = new HashMap<>();
    dynamic.put("schema", ...); //fill the whole structure
    return dynamic;
}