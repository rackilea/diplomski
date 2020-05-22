@Inject
    private DataSource ds;

    @GET
    @Path("dump")
    public Response dump() {


        try (Connection c = ds.getConnection(); Statement s = c.createStatement()) {

            s.execute("SCRIPT TO '/home/artur/tmp/test/test.sql'");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Response.ok().build();
    }