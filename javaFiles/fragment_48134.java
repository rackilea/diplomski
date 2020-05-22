Gson gson = new Gson();
JsonElement je = gson.toJsonTree(new Foo());
JsonObject jo = new JsonObject();
jo.add("Foo", je);
System.out.println(jo.toString());
// Prints {"Foo":{"number":10,"str":"hello"}}