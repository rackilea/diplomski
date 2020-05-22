@POST
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public Product createProduct(Product product) {
    try {
        Gson gson = new GsonBuilder()
        //.registerTypeAdapter(Calendar.class, new CalendarSerializer())
        //          .registerTypeAdapter(Calendar.class, new CalendarDeserializer())
        //          .registerTypeAdapter(GregorianCalendar.class,
        //                  new CalendarSerializer())
                            .create();

        String json = null;

        //do something

        json = gson.toJson(product);
        return Response.ok(json, MediaType.APPLICATION_JSON).build();


        }catch (IllegalArgumentException ex){
            return Response.serverError().status(Status.BAD_REQUEST).build();

        }catch (Exception ex) {
            return Response.serverError().status(Status.INTERNAL_SERVER_ERROR).build();
        }
        finally{
    }
}