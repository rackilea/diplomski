Map<String, T> enumConstantDirectory() {
    if (enumConstantDirectory == null) {
        T[] universe = getEnumConstantsShared();
        if (universe == null)
            throw new IllegalArgumentException(
                getName() + " is not an enum type");
        Map<String, T> m = new HashMap<>(2 * universe.length);
        for (T constant : universe)
            m.put(((Enum<?>)constant).name(), constant);
        enumConstantDirectory = m;
    }
    return enumConstantDirectory;
}