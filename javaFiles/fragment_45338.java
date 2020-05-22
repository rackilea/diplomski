@PUT
@Accepts("application/xml")
public Response putThing(Thing theThing) {
  // save theThing
  URI theThingUri = new URI(...);
  return Response.created(theThingUri).build();
}

@XmlRootElement
public class Thing {
  // members, constructors, getter, setter
}