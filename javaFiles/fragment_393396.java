// the JSON classes have package javax.json

ByteArrayOutputStream baos = new ByteArrayOutputStream();

// read JSON into baos

ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
InputStreamReader isr = new InputStreamReader(bais, Charset.forName("UTF-8"));
JsonReader jr = Json.createReader(isr);

JsonStructure js = jr.read();

switch (js.getValueType()) {
    case ARRAY:
        break;
    case OBJECT:
        break;
    case STRING:
        break;
    case NUMBER:
        break;
    case TRUE:
        break;
    case FALSE:
        break;
    case NULL:
        break;
}