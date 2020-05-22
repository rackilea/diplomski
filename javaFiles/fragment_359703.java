public class PetAdapter extends TypeAdapter<Owner> {

    @Override
    public void write(JsonWriter out, Owner value) throws IOException {

        out.beginObject();
        out.name("id");
        out.value(value.getId());
        out.endObject();

        //NOT USE PET
    }

    @Override
    public Owner read(JsonReader in) throws IOException {
        return null;
    }
}