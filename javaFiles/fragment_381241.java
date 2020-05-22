static Data testUsingStreaming(final Reader reader)
        throws IOException {
    final List<MyObject> myObjects = new ArrayList<>();
    final JsonReader jsonReader = new JsonReader(reader);
    jsonReader.beginArray();
    while ( jsonReader.hasNext() ) {
        jsonReader.beginObject();
        while ( jsonReader.hasNext() ) {
            switch ( jsonReader.nextName() ) {
            case "data":
                jsonReader.beginObject();
                while ( jsonReader.hasNext() ) {
                    switch ( jsonReader.nextName() ) {
                    case "value":
                        jsonReader.beginObject();
                        while ( jsonReader.hasNext() ) {
                            switch ( jsonReader.nextName() ) {
                            case "instruments":
                                final String instrumentsJson = jsonReader.nextString();
                                parseInstruments(instrumentsJson, myObjects);
                                break;
                            default:
                                jsonReader.skipValue();
                                break;
                            }
                        }
                        jsonReader.endObject();
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                    }
                }
                jsonReader.endObject();
                break;
            default:
                jsonReader.skipValue();
                break;
            }
        }
        jsonReader.endObject();
    }
    jsonReader.endArray();
    return new Data(myObjects);
}

private static void parseInstruments(final String instrumentsJson, final Collection<MyObject> myObjects)
        throws IOException {
    final JsonReader jsonReader = new JsonReader(new StringReader(instrumentsJson));
    jsonReader.setLenient(true);
    jsonReader.beginArray();
    while ( jsonReader.hasNext() ) {
        String mnemonic = null;
        Float percentChange = null;
        jsonReader.beginObject();
        while ( jsonReader.hasNext() ) {
            final String name = jsonReader.nextName();
            switch ( name ) {
            case "mnemonic":
                mnemonic = jsonReader.nextString();
                break;
            case "percentChange":
                percentChange = (float) jsonReader.nextDouble();
                break;
            default:
                jsonReader.skipValue();
                break;
            }
        }
        if ( mnemonic != null && percentChange != null ) {
            myObjects.add(new MyObject(mnemonic, percentChange));
        }
        jsonReader.endObject();
    }
    jsonReader.endArray();
}