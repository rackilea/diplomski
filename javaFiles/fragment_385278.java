void delete(List<? extends Object> list){
    for (Object o: list) {
        if (o instanceof ClassA) {
            delete((ClassA) o);
        } else if (o instanceof ClassB) {
            delete((ClassB) o);
        }
    }
}