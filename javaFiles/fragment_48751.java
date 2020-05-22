@GET
    @Path("getStdErr/{idApp}")
    @Produces("text/html; charset=UTF-8")
    public Response getStdErr(@PathParam("idApp") Integer idApp) {
        return super.getStderr(jobsMap.get(idApp));
    }