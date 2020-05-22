public static class MyUUIDAdapter implements JsonbAdapter<UUID, String> {

    @Override
    public String adaptToJson(UUID obj) throws Exception {
        return obj.toString();
    }

    @Override
    public UUID adaptFromJson(String obj) throws Exception {
        return UUID.fromString(obj);
    }

}