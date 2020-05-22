List<String> result = new ArrayList<>();
buildPath(path, "start", result);

void buildPath(Map<String, String> path, String token, List<String> result) {
    if (token != null) {
        result.add(token);
        buildPath(path, path.get(token), result);
    }
}