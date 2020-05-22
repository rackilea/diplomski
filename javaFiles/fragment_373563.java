public List<Message> readJsonStream(InputStream in) throws IOException {
    JsonReader reader = new JsonReader(new InputStreamReader(in, "UTF-8"));
    List<Message> messages = new ArrayList<Message>();
    reader.beginArray();
    while (reader.hasNext()) {
        Message message = gson.fromJson(reader, Message.class);
        // TODO : write an if statement
        if(someCase) {
            messages.add(message);
            // if you want to use less memory, don't add the objects into an array. 
            // write them to the disk (i.e. use sql lite, shared preferences or a file...) and
            // and retrieve them when you need.
        }
    }
    reader.endArray();
    reader.close();
    return messages;
}