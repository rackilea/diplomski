private <T> Enumeration<T> castEnumeration(Enumeration<?> elements) {
    Vector<T> converstionVector = new Vector<T>();
    while (elements.hasMoreElements()) {
        try {
            converstionVector.add((T) elements.nextElement());
        } catch (Exception e) {
        }
    }
    return converstionVector.elements();
}