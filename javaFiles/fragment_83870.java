String[] keys = {"key1", "user2", "somethingelse"};
for (final String key : keys) {
    if (holder.containsKey(key)) {
        // ... process the found key and value
        break;
    }
}