try {
    return Response.ok(successResult).build();
} catch(Exception ex) {
    return Response.serverError().entity(fault).build();
    //or
    return Response.status(500).entity(fault).build();
}