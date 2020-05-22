public abstract class MapAsArrayDeserializer<Type extends Map> extends JsonDeserializer<Type> {

    protected Type newMap(Collection c, Type returned) {
        for(Object o : c) {
            if (o instanceof List) {
                List l = (List) o;
                if(l.size()==2) {
                    Iterator i = l.iterator();
                    returned.put(i.next(), i.next());
                }
            }
        }
        return returned;
    }

    protected abstract Type createNewMap() throws Exception;

    @Override
    public Type deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        if(jp.getCurrentToken().equals(JsonToken.START_OBJECT)) {
            JsonToken nameToken = jp.nextToken();
            String name = jp.getCurrentName();
            if(name.equals("entries")) {
                jp.nextToken();
                Collection entries = jp.readValueAs(Collection.class);
                JsonToken endMap = jp.nextToken();
                try {
                    return newMap(entries, createNewMap());
                } catch(Exception e) {
                    throw new IOException("unable to create receiver map", e);
                }
            } else {
                throw new IOException("expected \"entries\", but field name was \""+name+"\"");
            }
        } else {
            throw new IOException("not startying an object ? Not possible");
        }
    }

    @Override
    public Type deserializeWithType(JsonParser jp, DeserializationContext ctxt, TypeDeserializer typeDeserializer) throws IOException,
                    JsonProcessingException {
        Object value = typeDeserializer.deserializeTypedFromObject(jp, ctxt);
        return (Type) value;
    }
}