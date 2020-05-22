//HashMap Example
@GET
@Path("add/{num1}/{num2}")
public String Hashmap(@PathParam("num1") int num1, @PathParam("num2") int num2){
          HashMap<String, Integer> map = new HashMap<>();
          map.put("result", num1+num2);
          Gson gson = new Gson();
          return gson.toJson(map);
}