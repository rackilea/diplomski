Set<String> keys = new HashSet<String>(listOKeys);

for (String header : listOHeaders) {
    if (keys.contains(header)) {
        // process
    }
}