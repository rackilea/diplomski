@GET
    @Path("/order")
    @Produces(MediaType.APPLICATION_JSON)

public Map<String,List<Order>> getAllorder(){
    List <Order> list = new ArrayList<>();
    List <Order> list = orderDao.getAll();
    LinkedHashMap<String,List<Order>> map = new LinkedHashMap<>();
    map.put("order", list);
    return map;
}