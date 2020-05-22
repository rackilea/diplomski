public C findMax(C[] xs){
   return findMax(xs, Comparator.naturalOrder());
}

public C findMax(C[] xs, Comparator<? super C> c){
    return Arrays.stream(xs).max(c).orElse(null);
}