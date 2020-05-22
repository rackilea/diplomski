@POST
@Consumes(APPLICATION_JSON)
@ApiOperation(value = "Create promotion", notes = "", response = Promotion.class)
@ApiResponses(value = {
        @ApiResponse(code = 201, message = "Promotion created. Link to it in Location HEADER."),
        @ApiResponse(code = 409, message = "Promotion already exist.")
})
public Response create(@ApiParam final Promotion promotion, @Context final UriInfo uriInfo) throws IOException {
    Promotion createdPromotion = promotionManagementService.create(promotion);

    URI createdPromotionURI = uriTo(createdPromotion, uriInfo);
    return Response.created(createdPromotionURI).build();
}