@Produce("application/json")
public Response someMethod() {

    switch(mySpecialCase) {
        case 1:
            return Response.ok(coreEntity).build(); break;
        case 2:
            return Response.ok(new LiteEntity(coreEntity)).build(); break;
        case 3:
            return Response.ok(Util.toGSON(coreEntity).toString()).build(); break;
    }
}