JsonObject inputObject=new JsonObject();
JsonObject triggerObject=new JsonObject();
JsonObject mainObject=new JsonObject();
try{
   inputObject.put("auth","EaIv0NlXiDWJrpvLkAdP");
   inputObject.put("domain","rangersrockerz");

   triggerObject.put("input",inputObject);
   triggerObject.put("name","new user2");

   mainObject.put("trigger",triggerObject);

} catch(Exception e){
}