public ConceptIntersection(List<Concept> l) throws Exception {
    if(l.size()>1) {
        this.list = new ArrayList<>(l);
    } else {
        throw new Exception("Intersection needs at least two concepts!");
    }
}