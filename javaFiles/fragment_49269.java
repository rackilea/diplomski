void removeChild(Child toRemove) {
    for (Parent p : toRemove.getParents())  {
        p.setChild(null);
        em.merge(p);
    }
    em.delete(toRemove);
}