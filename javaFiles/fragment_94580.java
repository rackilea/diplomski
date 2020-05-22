Map<APojo, Map<BPojo, CPojo>> result =
using(configuration()).select(A.fields())
        .select(B.fields())
        .select(C.fields())
        .from(A)
        .leftJoin(B).on(B.aId.eq(A.aId))
        .leftJoin(C).on(C.cId.eq(B.cId))
        .fetch()
        .stream()
        .collect(Collectors.groupingBy(
            r -> r.into(A).into(APojo.class),
            Collectors.toMap(
                r -> r.into(B).into(BPojo.class),
                r -> r.into(C).into(CPojo.class))));