public class StreamUserDeserializer extends TypeAdapter<User> {

    @Override
    public void write(JsonWriter out, List<CMPoint> value) throws IOException {

    }

    @Override
    public User read(JsonReader in) throws IOException {
        User user = new User();

        in.beginObject();
        while (in.hasNext()) {
            switch (in.nextName()) {
                case "name":
                    user.getPerson().setName(in.nextString());
                    break;

                case "age":
                    user.getPerson().setAge(in.nextInt());
                    break;

                case "phone":
                    user.getPersonContacts().setPhone(in.nextString());
                    break;

                case "email":
                    user.getPersonContacts().setEmail(in.nextString());
                    break;

                default:
                    in.skipValue();
            }
        }
        in.endObject();

        return user;
    }

}