public <T> void m(List<T[]> objs){
    objs.stream()
            .map(oa -> oa[0])   // no compile error
            .forEach(System.out::println);

}