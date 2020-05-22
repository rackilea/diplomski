@Override
public void filter(ContainerRequestContext crc) throws IOException {
    MyObject obj = new MyObject();
    crc.setProperty("myObject", myObject);
}

@POST
public Response getResponse(@Context ContainerRequestContext crc) {
    return Response.ok(crc.getProperty("myObject")).build();
}