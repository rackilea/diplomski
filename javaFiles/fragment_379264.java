for (int i = 0; i < arrayList.size() - 1; i++) {
    Double db = arrayList.get(i);
    for (int j = i + 1; j < arrayList.size(); j++) {
        Double db2 = arrayList.get(j);

        // Don't use == unless you *really* want reference identity
        if (!db2.equals(db)) {
            ...
        }
    }
}