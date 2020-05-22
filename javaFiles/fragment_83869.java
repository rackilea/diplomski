for (int i = 1; i <= 4; i++) {
    final String key = "user" + i;
    if (holder.containsKey(key)) {
        // ... process the found key and value
        break;
    }
}