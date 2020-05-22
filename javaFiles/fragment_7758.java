public static <T> List<T> filter(List<T> list, Predicate<T> predicate){
    List<T> result = new ArrayList<>();
    for(T el : list){
        if(predicate.pass(el)){
            result.add(el);
        }
    }

    return result;
}