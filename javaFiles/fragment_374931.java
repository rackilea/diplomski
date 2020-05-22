GSFileOptionsBuilder optionsBuilder = new GSFileOptionsBuilder()
  .setBucket("my_bucket") 
  .setKey("my_object")
  .setAcl("public-read")
  .setMimeType("text/html") //etc etc
  .setUserMetadata("date-created", "01/09/2011", "owner", "Jon");