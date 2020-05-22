private static Predicate addSynonymsWithJoins(Root<BioObjectImpl> r, CriteriaBuilder b, CriteriaQuery cq,
        Attribute attr, Path path, Object value) {
    Join taxJoin = r.join(BioObjectEnum.taxon.name(), JoinType.INNER);

    Path<Object> taxValidSynonymId = taxJoin.get(TaxonEnum.validSynonymId.name());
    Subquery<TaxonImpl> innerSubquery = cq.subquery(TaxonImpl.class);
    Root fromSubTax = innerSubquery.from(TaxonImpl.class);
    innerSubquery.select(fromSubTax.<Integer> get(TaxonEnum.id.name()));
    Predicate dynamic1 = cb.like(fromSubTax.get(TaxonEnum.name.name()),
     NAME_LIKE);
    innerSubquery.where(dynamic1);
    Predicate dynamic2 = resolveComparator(b, attr, taxJoin.get(attr.getPropertyName()), attr.getValue());//
    Predicate p = b.or(taxValidSynonymId.in(innerSubquery), dynamic2);

    return p;
}

private static Predicate addSynonymsWithoutJoins(Root<BioObjectImpl> r, CriteriaBuilder b, CriteriaQuery cq,
        Attribute attr, Path path, Object value) {
    cq.select(r);

    Path<Integer> objTaxonId = r.<Integer> get(BioObjectEnum.taxon.name()).get(TaxonEnum.id.name());

    Subquery<Integer> t2 = cq.subquery(Integer.class);
    Root<TaxonImpl> t2fromTaxon = t2.from(TaxonImpl.class);
    Path<Integer> t2taxId = t2fromTaxon.<Integer> get(TaxonEnum.validSynonymId.name());
    t2.select(t2taxId);
    Predicate t2dynamicWhere = resolveComparator(b, attr, t2fromTaxon.get(attr.getPropertyName()), attr.getValue());
    t2.where(t2dynamicWhere);

    Subquery<Integer> t1 = cq.subquery(Integer.class);
    Root<TaxonImpl> t1fromTaxon = t1.from(TaxonImpl.class);
    Predicate t1dynamicWhere = b.like(fromSubTax.get(TaxonEnum.name.name()),
     NAME_LIKE);
    Path<Integer> t1Select = t1fromTaxon.<Integer> get(TaxonEnum.id.name());

    t1.select(t1Select);
    Path<Integer> t1TaxSynonymId = t1fromTaxon.<Integer> get(TaxonEnum.validSynonymId.name());
    t1dynamicWhere = b.or(t1dynamicWhere, t1TaxSynonymId.in(t2));
    t1.where(t1dynamicWhere);

    Predicate where = objTaxonId.in(t1);
    return where;
}