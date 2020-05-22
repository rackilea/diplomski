class BookTypeAdapter implements JsonSerializer<Book>, JsonDeserializer<Book>
{
      Gson gson = new Gson();

      public JsonElement serialize(Book book, Type typeOfT, JsonSerializationContext context)
      {
          JsonObject json = new JsonObject();

          for (User user : book.getUser())
          {
              json.addProperty(user.getName(), gson.toJson(user));
          }

          return json;
      }

      public Book deserialize(JsonElement element, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
      {
          JsonObject json = element.getAsJsonObject();

          Book book = new Book();

          for (Entry<String, JsonElement> entry : json.entrySet())
          {
              String name = entry.getKey();
              User user = gson.fromJson(entry.getValue(), User.class);
              user.setName(name);

              book.getUser().add(user); 
          }

          return book;
      }
}