public  T get(Class<T> clazz, long nip) throws InstantiationException, IllegalAccessException {

    T myT = cache.getFromMap(nip);
    if (myT == null) {

        T newT = clazz.newInstance();
        putT(newT);

        return newT;

    } else
        return myT;

}