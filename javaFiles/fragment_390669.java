@GET
    @Path("/download/{filePath}")

    @Produces(MediaType.APPLICATION_OCTET_STREAM)
    public Response getdownloadFile(@PathParam("filePath") String filePath) {
        String path = null;

            byte [] barr = Base64.getDecoder().decode(filePath);
            path = new String(barr);
        File file = new File(path);
        try {
            String contentType = Files.probeContentType(file.toPath());

            Response.ResponseBuilder response = Response.ok((Object) file);
            response.header("Content-Disposition", "attachment; filename="+file.getName());
            response.header("Content-Type", contentType);
            response.header("Content-Length", file.length());
            return response.build();
        } catch (IOException e) {
            e.printStackTrace();
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }