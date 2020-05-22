public void remove(String json, List<String> path) {

    JsonNode root = new ObjectMapper.readTree(json);

    int lastIndex = path.size() - 1;

    for (int i = 0; i < lastIndex; i++) {
        root = root.get(path.get(i));
    }

    root = root.remove(path.get(lastIndex));

    return root;
}