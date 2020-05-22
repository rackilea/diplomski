@Test
public void testShouldSkipField() {

   Gson gson;      
   Table table = new Table();

   Collection<String> serializedFields = new ArrayList<>();

   ArrayList<Table> myTable = new ArrayList<Table>();
   myTable.add(new Table("John", "Chicago"));
   myTable.add(new Table("David", "Seattle"));
   myTable.add(new Table("June", "Dallas"));

   serializedFields.add("name");
   gson = new GsonBuilder()
         .setPrettyPrinting()
         .addSerializationExclusionStrategy(
                new FieldExclusionStrategy(serializedFields))
         .create();
   log.info("\n{}", gson.toJson(myTable));      

   serializedFields.add("location");      
   gson = new GsonBuilder()
         .setPrettyPrinting()
         .addSerializationExclusionStrategy(
                new FieldExclusionStrategy(serializedFields))
         .create();
   log.error("\n{}", gson.toJson(myTable));      

   serializedFields.remove("name");      
   gson = new GsonBuilder()
         .setPrettyPrinting()
         .addSerializationExclusionStrategy(
                new FieldExclusionStrategy(serializedFields))
         .create();
   log.error("\n{}", gson.toJson(myTable));      

}