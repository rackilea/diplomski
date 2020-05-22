Set<E> copied = new HashSet<>();
List<E> res = new ArrayList<>();
for(E e : originalList) {
    if(!copied.contains(e)) {
        res.add(e);
    }
    copied.add(e);
}