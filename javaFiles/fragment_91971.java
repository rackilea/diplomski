class Container {

    Set<Object> set;

    @Override 
    int hashCode() {
        return set.hashCode(); 
    }
}