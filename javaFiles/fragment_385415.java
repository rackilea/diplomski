JsonArray jsonElements = new JsonParser().parse(response).getAsJsonArray();
for (int i = 0; i < jsonElements.size(); i++) {
        JsonObject jObject = jsonElements.get(i).getAsJsonObject();
        // edited here 
        String primary_photo = jObject.get("primary_photo").getAsString();
        JsonObject author = jObject.getAsJsonObject("author");
        String profile_photo = author.get("profile_photo").getAsString();
}