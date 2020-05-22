@GET
@Path("/calendar/{origin}/{destination}/{outwardDate}/{returnDate}")
public Response getInfo(@PathParam("origin") String origin,
                        @PathParam("destination") String destination, 
                        @PathParam("outwardDate") String outwardDate, 
                        @PathParam("returnDate") String returnDate,
                        @QueryParam("nbPax") String nbPax, 
                        @QueryParam("typo") String typo, 
                        @QueryParam("card")  String card) {