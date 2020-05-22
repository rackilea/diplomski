public static Long getLong(JsonNode node, String name) {
    if (node.get(name) != null && node.get(name).isLong()) {
        return node.get(name).asLong();
    } else {
        return null;
    }
}