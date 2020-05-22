/**
 * Retrieves representation of an instance of contentmanagement.ContentManagement
 * @return an instance of java.lang.String
 */
@GET @Path("getHtml")
@Produces("application/json")
public String getGuests() {
    JSONArray myData = new JSONArray();

    for(Guest item : guestDao.getAllGuests()) {
        myData.put(new JSONObject().put("id", item.getID())
          .put("name", item.getName()));
    } 

    return myData.toString();
}