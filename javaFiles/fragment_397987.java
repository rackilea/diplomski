@POST
public void register(@Context SecurityContext context, CreateAccountJson account) {

    if (context.getUserPrincipal() != null) {
        throw new NotFoundException();
    }
    ...
}