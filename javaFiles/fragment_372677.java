public class MySqlResource{

    private final ExecutorService executor;

    public MySqlResource() {
        this.executor = Executors.newFixedThreadPool(1);
    }

    @POST
    @Path("insertOrUpdate")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertOrUpdate(final String user) {

        try {
            new MYSQLProvider().insertOrUpdate(user);
            resulTObj.put("success", true);
            resulTObj.put("msg", "");

            executor.execute( new Runnable() {

                @Override
                public void run() {
                    //...run() code goes here
                }
            });
        } catch (SQLException | JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            resulTObj.put("success", false);
            resulTObj.put("msg", e.getMessage());
        }

        return  Response.status(200).entity(resulTObj.toString()).build();
    }
}