public class ParentExtended extends Parent {
    private List<Child> childrenObjects;

    public ParentExtended(Parent parent) {
        this.id = parent.getId();
        ...
    }

    @JsonProperty("children")
    public List<Child> getChildrenObjects() { ... }

    @Override
    @JsonIgnore
    public List<String> getChildren() { ... }
}


@Path("/some/parent")
@Produces(MediaType.APPLICATION_JSON)
public class ParentResource() {
    @GET
    public List<Parent> findAll() {
        List<Parent> result = // some database query call
        return result;
    }

    @GET
    @Path("{id}")
    public ParentExtended find(@PathParam("id") String id) {
        Parent parent = // some database call
        ParentExtended parentEx = new ParentExtended(parent);

        for (String childId : parent.getChildren()) {
            parentEx.getChildrenObjects().add(// fetch the child object);
        }
        return parentEx;
    }
}