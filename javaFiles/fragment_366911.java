Record r = dslContext
                .select()
                .from(Tables.X)
                .leftJoin(Tables.Y)
                .on(Tables.X.SOME_ID.eq(Tables.Y.ID))
                .where(Tables.X.IS.eq(id))
                .fetchOne();

if (r != null) {
    XRecord x = r.into(Tables.X);
    YRecord y = r.into(Tables.Y);
}