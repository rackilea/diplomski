@Path("stream")
public class StreamResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStream() {
        List<Person> myList = Arrays.asList(
                              new Person("Stack"), 
                              new Person("Overflow"),
                              new Person("Sam"));
        Stream<Person> stream = myList.stream()
                                      .filter(p -> p.name.startsWith("S"));
        return Response.ok(stream).build();
    }

    public static class Person {
        public String name;
        public Person(String name) { this.name = name; }
        public Person() {}
    }
}