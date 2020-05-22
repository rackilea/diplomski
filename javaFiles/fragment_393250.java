private <T> T convertFromString(String value, Class<T> type) {
    Gson gson = new Gson();
    return gson.fromJson(value, type);
}

private String convertToString(Object object) throws IOException {
    Gson gson = new Gson();
    return gson.toJson(object);
}