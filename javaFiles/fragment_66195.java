@RequestMapping(
    value = "/some-post-endpoint", 
    method = RequestMethod.POST)
public void post(@RequestBody Map<String, Object> payload) 
    throws Exception {

  System.out.println(payload);

}