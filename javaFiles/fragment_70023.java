@GET
    @Produces(Metodos.Parametros.TYPE_IMAGE_PNG)
    public Response getImage() {
        byte[] bytes = Files.toByteArray("file.png");
        return Response.ok(bytes).build();
    }