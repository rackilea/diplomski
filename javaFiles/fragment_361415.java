List<Person> arrPersons = new ArrayList<Person>();

// populate your list

Gson gson = new Gson();
JsonElement element = gson.toJsonTree(arrPersons, new TypeToken<List<Person>>() {}.getType());

if (! element.isJsonArray()) {
// fail appropriately
    throw new SomeException();
}

JsonArray jsonArray = element.getAsJsonArray();