@POST
@Consumes({MediaType.APPLICATION_JSON})
@Path("/")
void createJson(@Suspended final AsyncResponse asyncResponse,
                        @ApiParam(required = true) @NotNull @Valid final CreateServiceRequest service) {
    create(service)
}


@POST
@Consumes({MediaType.APPLICATION_FORM_URLENCODED})
@Path("/")
void createJson(@Suspended final AsyncResponse asyncResponse,
                        @ApiParam(required = true) @NotNull @Valid final CreateServiceRequest service) {
    create(service)
}