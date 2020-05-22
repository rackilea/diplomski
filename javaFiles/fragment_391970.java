public void add(String key, List<LatLng>value) {
    internalStorage.put(key, value);
}

public List<LatLng>get(String key) {
    return internalStorage.get(key);
}