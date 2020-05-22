Bson filter = null;
Bson update = null;

filter = and(eq("name", "john"), eq("location", "Pune"));
update = combine(set("id", "789"), set("name", "alex"));
UpdateOptions options = new UpdateOptions();
options.upsert(true);
dbCollection.updateMany(filter, update, options);