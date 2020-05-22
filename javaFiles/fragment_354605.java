@GetMapping(value = "/user/",produces = "application/JSON")
public Map<String,Object> getUser(){
    Map<String,Object> result = new HashMap<String,Object>();
    List<String> newUsers = new ArrayList<String>();
    newUsers.add("User 1");
    newUsers.add("User 2");
    newUsers.add("User 3");
    result.put("users" , newUsers);
    return result;
}