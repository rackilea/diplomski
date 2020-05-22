Gson gson = new Gson();


.map(JsonElement::getAsJsonObject)
                .forEach(jsonObject -> custom.add(gson.fromJson(jsonObject.toString(),MyClass.class)))
);