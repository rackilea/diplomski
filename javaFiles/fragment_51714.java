public List<User> getUsers() {
    Map<String, Object> params = new HashMap<String, Object>(); 
    ResultSet rs = null;
    params.put("users", rs);
    userMapper.getUsers(params);
    return ((ArrayList<User>)params.get("users"));
}