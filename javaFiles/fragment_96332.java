@Path("jackson-xml")
public class JacksonXmlResource {

    @GET
    @Produces("application/xml")
    public Response get() {
        Model model = new Model();
        model.setProp("foo", "bar");
        model.setProp("name", "Paul");
        return Response.ok(model).build();
    }


    public static class Model {
        private Map<String, Object> props = new HashMap<>();

        @JsonAnyGetter
        public Map<String, Object> getProps() {
            return this.props;
        }

        @JsonAnySetter
        public void setProp(String key, Object value) {
            this.props.put(key, value);
        }
    }
}