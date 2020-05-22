@POST
    @Path("/sendarraylist")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    MyArrayList modifyList(@QueryParam("arraylist") MyArrayList list) {
        //do stuff
    }