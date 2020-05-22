@Api(name = "myendpoint", namespace = @ApiNamespace(ownerDomain = "domain.com", ownerName =                    "domain.com.com", packagePath = "myPackage"))
 public class MyEndpoint {

    /**
     * This method lists all the entities inserted in datastore.
      * It uses HTTP GET method and paging support.
 *
 * @return A CollectionResponse class containing the list of all entities
 * persisted and a cursor to the next page.
 */
@SuppressWarnings({ "unchecked", "unused" })
@ApiMethod(name = "listStuff")
public CollectionResponse<Stuff> listStuff(
        @Nullable @Named("cursor") String cursorString,
        @Nullable @Named("limit") Integer limit) {

    EntityManager mgr = null;
    Cursor cursor = null;
    List<Stuff> execute = null;

    try {
        mgr = getEntityManager();
        Query query = mgr
                .createQuery("select from Stuff as Stuff");
        if (cursorString != null && cursorString != "") {
            cursor = Cursor.fromWebSafeString(cursorString);
            query.setHint(JPACursorHelper.CURSOR_HINT, cursor);
        }

        if (limit != null) {
            query.setFirstResult(0);
            query.setMaxResults(limit);
        }

        execute = (List<Stuff>) query.getResultList();
        cursor = JPACursorHelper.getCursor(execute);
        if (cursor != null)
            cursorString = cursor.toWebSafeString();

        // Tight loop for fetching all entities from datastore and accomodate
        // for lazy fetch.
        for (Stuff obj : execute)
            ;
    } finally {
        mgr.close();
    }

    return CollectionResponse.<Stuff> builder().setItems(execute)
            .setNextPageToken(cursorString).build();
}