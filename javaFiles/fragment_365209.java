QResource r = QResource.resource;
QProperty p = QProperty.property;
queryFactory
    .select(p.key, p.value.count())
    .from(r)
    .join(p).on(r.id.eq(p.id))
    .where(p.key.eq("key"), p.value.eq("value"))
    .groupBy(p.value)
    .fetchOne();