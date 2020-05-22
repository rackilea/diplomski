@Path("/v1")
@Tags(@Tag(name = "test", description = ""))
public class FooResource {

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/{FieldId}")
    @Operation(operationId = "modifyFoo", summary = "Modifies a Foo entity")
    public void modify(@ParameterAlias(MyAnnotator.class) final FieldId fieldId) {

    }
}