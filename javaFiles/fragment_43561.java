@SuppressWarnings("unchecked")
    public MODEL read(ID id) {
        Field keyField2 = getKeyField(model);
        BasicDBObject query = createQuery(keyField2.getName(), id.toString());

        DBCursor cursor = dbCollection.find(query);
        if (!cursor.hasNext()) {
            throw new RuntimeException(String.format("This id %s isn't presented at collection %s", id.toString(), dbCollection.getFullName()));
        }
        String json = cursor.next().toString();
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        MODEL value   = null;
        try {
            value = mapper.readValue(json, model);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }