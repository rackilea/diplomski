public static <K,T,R> Map<K,R> changeValues(
       Map<? extends K, T> in, Function<? super T, ? extends R> f) {

    Map<K,R> result = new HashMap<>(in.size());
    in.forEach((k,t) -> result.put(k, f.apply(t)));
    return result;
}

public static Map<String, Map<String, String>> convertRawMapToStringValues(
       Map<String, Map<String, Object>> in) {

    return changeValues(in, inner -> changeValues(inner, v -> v==null? null: v.toString()));
}