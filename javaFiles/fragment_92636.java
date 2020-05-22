JsonObjectBuilder jsonObject = Json.createObjectBuilder();
jsonObject.add("name", "test");
jsonObject.add("lastname", "test");

JsonArrayBuilder jsonArray = Json.createArrayBuilder();
for(MyImage image : images)
{
   JsonObjectBuilder imageJson = Json.createObjectBuilder();
   imageJson.add("imageName", image.getImageName());
   imageJson.add("imageBytes", image.getImageBytes());
   jsonArray.add(imageJson.build());
}
jsonObject.add("images", jsonArray.build());

JsonObject data = jsonObject.build();
callWcfService(data);