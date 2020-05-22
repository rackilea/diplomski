@Override
public JsonElement serialize(ControlTransaction ctr, Type type,
        JsonSerializationContext context) {
    return new GsonBuilder().registerTypeAdapter(
            ControlTransaction.class,
              new ControlTransactionSerializer()).create().toJsonTree(ctr);
}