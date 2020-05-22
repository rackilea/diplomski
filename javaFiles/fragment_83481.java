public class PersonDetailsSerializer extends StdSerializer<PersonDetails> {

    public PersonDetailsSerializer() {
        this(null);
    }

    public PersonDetailsSerializer(Class<PersonDetails> t) {
        super(t);
    }

    @Override
    public void serialize(
            PersonDetails personDetails, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonProcessingException {
        // custom behavior if you implement equals and hashCode in your code
        if(personDetails.equals(new PersonDetails()){
           return;
        }
        super.serialize(personDetails,jgen,provider);
    }
}