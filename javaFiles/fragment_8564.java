@POST
@Path("path")
@Produces({MediaType.APPLICATION_JSON})
public Response isSellableOnline(@FormParam("productCodes") final List<String> productCodes,
                                 @FormParam("storeName") final String storeName,
                                 @Context HttpServletRequest request) {

      System.out.println(storeName);
      System.out.println(productCodes.size());
      ...
}