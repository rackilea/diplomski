for (int i = 0; i < list.size(); i++) {
    if (Collections.frequency(list, list.get(i)) > 1) {
        String uuids = UUID.randomUUID().toString().replace("-", "");
        list.set(i, uuids);
    }
}