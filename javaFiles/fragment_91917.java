public <T> List<T> get(String key, Type type) {
    return this.gson.fromJson(this.data.get(key), type);
}

public <T> void set(String key, List<T> value, Type type) {
    this.data.put(key, this.gson.toJson(value, type));
}