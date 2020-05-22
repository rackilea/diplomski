JsonObject jo = FetchData.getAllItemsAvg(
                          request.getParameter("where"),
                          request.getParameter("lastNum"),
                          request.getParameter("limitAvgNum"));
JsonArray ja = new JsonArray();
if(!jo.entrySet().isEmpty()){
    ja.add(jo);
}