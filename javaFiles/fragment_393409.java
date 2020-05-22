public static <E> int numberMaximus(Collection<E> coleccion, Comparator<? super E> comparador){
    E maximo;
    Comparator<? super E> comp = comparador;
    if (comp == null) {
        comp = (o1, o2) -> ((Comparable<E>)o1).compareTo(o2);
    }

    maximo = coleccion.stream().max(comp).orElse(null);
    if (maximo == null) {
        return 0;
    }
    return (int)coleccion.stream().filter(x -> x == maximo).count();
}