JsonObject jsonObject = new Gson().fromJson(jsonInput2, JsonObject.class);

String name = jsonObject.get("user")       // get the 'user' JsonElement
                        .getAsJsonObject() // get it as a JsonObject
                        .get("name")       // get the nested 'name' JsonElement
                        .getAsString();    // get it as a String
System.out.println(name);