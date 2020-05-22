@GET
@Produces(MediaType.APPLICATION_JSON)
public Collection<User> listUsers( 
        @QueryParam("page") @DefaultValue("1") Integer page,
        @QueryParam("sortFields") @DefaultValue("id") String sortFields,
        @QueryParam("sortDirections") @DefaultValue("asc") String sortDirections) {

    PaginatedListWrapper listWrapper = new PaginatedListWrapper<>();
    listWrapper.setCurrentPage(page);
    listWrapper.setSortFields(sortFields);
    listWrapper.setSortDirections(sortDirections);
    listWrapper.setTotalResults(this.countAll());

    int start = (listWrapper.getCurrentPage() - 1) * listWrapper.getPageSize();
    return userFacade.findRange(new int[]{start, listWrapper.getPageSize()});
}