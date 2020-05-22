public class DateParamTest extends JerseyTest {

    private static final String FORMAT = "MM-dd-yyyy";

    @Path("date")
    public static class DateResource {
        @GET
        public String get(@MatrixParam("since") Date date) {
            return new SimpleDateFormat(FORMAT).format(date);
        }
    }

    @Override
    public ResourceConfig configure() {
        return new ResourceConfig(DateResource.class)
                .register(new DateParamConverterProvider(FORMAT));
    }

    @Test
    public void should_return_same_date_and_format() {
        final String date = "09-30-2015";
        Response response = target("date").matrixParam("since", date)
                .request().get();
        assertEquals(200, response.getStatus());
        String returnDate = response.readEntity(String.class);
        assertEquals(date, returnDate);
        System.out.println(returnDate);
    }
}