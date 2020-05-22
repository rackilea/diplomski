public static class Model {
    private String secured;

    @RolesAllowed({"ADMIN"})
    public String getSecured() { return this.secured; }
}