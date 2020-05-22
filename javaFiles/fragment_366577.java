JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
List<Message> messages = new ArrayList<Message>();
reader.beginArray();
while (reader.hasNext()) {
  Message message = gson.fromJson(reader, Message.class);
  messages.add(message);
}
reader.endArray();
reader.close();