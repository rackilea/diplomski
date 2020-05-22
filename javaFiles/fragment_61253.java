private <T> List<T> removeSameColor(List<T> list, Function<? super T, String> fn) {
    Set<String> colorSet = new HashSet<>();
    Iterator<T> iterator = list.iterator();
    while (iterator.hasNext()) {
        if(!colorSet .isEmpty() && colorSet .contains(fn.apply(iterator.next()))) {
            iterator.remove();
        }
        else{
            colorSet.add(fn.apply(iterator.next()));
        }
    }
    return list;
}