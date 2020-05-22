@RequestMapping(value = "/items/{category}/{name}", method=RequestMethod.GET)
  public String getItem(@PathVariable("category") String category, @PathVariable("name") String name){
     String productname= name;
     String category=category;
     //Do your stuff
  }