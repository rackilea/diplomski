@SuppressWarnings("unchecked")
    public static <T> T[][] toArray(List<List<T>> list, Class<T> type) {

    T aux[] = (T[]) Array.newInstance(type, 0);
    T auxBi[][] = (T[][]) Array.newInstance(type, 0, 0);

    List<T[]> newList = new ArrayList<>();
    list.forEach(e -> newList.add(e.toArray(aux)));

    T[][] newBi = newList.toArray(auxBi);

    return newBi;
}