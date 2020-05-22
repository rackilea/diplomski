@POST
@Path("apath")
@Consumes(MediaType.APPLICATION_JSON, MediaType.TEXT_HTML)
public Response randomAPI(@Context UriInfo uriInfo){
    Map params= (HashMap) convertMultiToHashMap(uriInfo.getQueryParameters());
    return service.doWork(params);
}

public Map<String, String> convertMultiToHashMap(MultivaluedMap<String, String> m) {
        Map<String, String> map = new HashMap<String, String>();
        for (Map.Entry<String, List<String>> entry : m.entrySet()) {
            StringBuilder sb = new StringBuilder();
            for (String s : entry.getValue()) {
                sb.append(s);
            }
            map.put(entry.getKey(), sb.toString());
        }
        return map;
    }