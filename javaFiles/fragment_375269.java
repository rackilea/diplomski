static <T> String mapAndJoin(Collection<T> c, Function<T,String> f){
    return c.stream()
            .map(f)
            .map(s -> "'" + s + "'")
            .collect(joining(","));
}

mapAndJoin(companies, Company::getId);