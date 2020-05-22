public <TEntry extends Entry<?>> TEntry createEntry(Class<TEntry> type, String folder) {
    if (StringEntry.class.equals(type)) {
        return type.cast(new StringEntry(folder));
    } else if (IntegerEntry.class.equals(type)) {
        return type.cast(new IntegerEntry(folder));
    }
    throw new IllegalArgumentException("Unknown type: " + type);
}