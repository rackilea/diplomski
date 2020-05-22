protected <T> T func(Class<T> c) {
    if (c.isEnum())
        for (T t : c.getEnumConstants())
            if (((Enum<?>) t).name().equals("KG"))
                return t;
    return null;
}