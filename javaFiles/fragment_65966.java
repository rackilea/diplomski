@POST
@Path("yourPath")
@Consumes(MediaType.APPLICATION_XML);
public Response createCustomerXML() {...}

@POST
@Path("yourPath")
@Consumes(MediaType.APPLICATION_JSON);
public Response createCustomerJSON() {...}