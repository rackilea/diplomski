class ConcreteStore implements Store<Child> {
    Set<Child> childs;
    public Set<Child> getParents() {
        return childs;
    }
}