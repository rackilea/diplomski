public static Object deepClone(Object toClone) { 
    Class<?> c = toClone.getClass();
    if (c.isArray()) {
        Object toReturn = Array.newInstance(c.getComponentType(), Array.getLength(toClone));
        for (int i = 0; i < Array.getLength(toReturn); i++) {
            Array.set(toReturn, i, deepClone(Array.get(toClone, i)));
        }
        return toReturn;
    }
    else {
        // toClone is an atom, so just return it
        return toClone;
    }
}