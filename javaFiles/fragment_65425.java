Derived derived = new Derived();

Gson gson = new Gson();
Type type = new TypeToken<Base>(){}.getType();

String jsonString = gson.toJson(derived, type);