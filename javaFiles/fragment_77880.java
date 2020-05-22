public void addCriterion(Criterion criterion) {
    criterions.add(comment);
    criterion.setFount(this);
}

public void removeCriterion(Criterion criterion) {
    criterions.remove(criterion);
    criterion.setFount(null);
}