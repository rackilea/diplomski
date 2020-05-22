@Path("/echo")
    public class Echo {
        @PUT
        @Produces({MediaType.APPLICATION_JSON})
        @Consumes(MediaType.TEXT_PLAIN)
        @Path("/{name}/{family}")
        public Response echoGet(
                @PathParam("name") String name,
                @PathParam("family") String family,
                String Desc
        ) {
            Map<String, Object> resp = new HashMap<>();
            resp.put("success", "true");
            resp.put("Name", name);
            resp.put("Family", family);
            resp.put("Desc", Desc);
            Response.ResponseBuilder rb = Response.ok(resp,
MediaType.APPLICATION_JSON).status(Response.Status.OK);
            return rb.build();
        }
    }