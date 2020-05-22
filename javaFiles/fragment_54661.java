@Override
public Boolean deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {
    if (jp.currentToken() == JsonToken.START_ARRAY) {
        jp.nextToken();
        int recursionLevel = 1;
        while(recursionLevel > 0) {
            switch (jp.currentToken()) {
                case START_ARRAY:
                    // just in case of nested arrays
                    recursionLevel++;
                    break;
                case END_ARRAY:
                    recursionLevel--;
                    break;
            }
            jp.nextToken();
        }
        return true;
    }
    return false;
}