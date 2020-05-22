Map<APojo, List<Tuple<BPojo, CPojo>>> result =
using(configuration()).select(A.fields())
        .select(B.fields())
        .select(C.fields())
        .from(A)
        .leftJoin(B).on(B.aId.eq(A.aId))
        .leftJoin(C).on(C.cId.eq(B.cId))
        .fetchGroups(
            r -> r.into(A).into(APojo.class),
            r -> tuple(
                     r.into(B).into(BPojo.class),
                     r.into(C).into(CPojo.class)));