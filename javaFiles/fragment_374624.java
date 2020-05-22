private <T> Enumeration<T> castEnumeration(Enumeration<?> elements, Class<T> tClass) {
    Vector<T> converstionVector = new Vector<T>();
    while (elements.hasMoreElements()) {
        try {
            converstionVector.add(tClass.cast(elements.nextElement()));
        } catch (Exception e) {
        }
    }
    return converstionVector.elements();
}