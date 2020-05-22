/**
 * Parse and process an arbitrarily large JSON array of Person documents
 */
@Path("persons")
public static class PersonResource {

    private static final ObjectReader reader = new ObjectMapper().readerFor(Person.class);

    @Path("inputstream")
    @Consumes("application/json")
    @POST
    public void inputstream(final InputStream is) throws IOException {
        final MappingIterator<Person> persons = reader.readValues(is);
        while (persons.hasNext()) {
            final Person person = persons.next();
            // process
            System.out.println(person);
        }
    }
}