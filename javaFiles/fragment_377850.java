public static <T> T[][] toArray(List<List<T>> list, T aux[], T auxBi[][]) {

    List<T[]> newList = new ArrayList<>();
    list.forEach(e -> newList.add(e.toArray(aux)));

    T[][] newBi = newList.toArray(auxBi);

    return newBi;

}