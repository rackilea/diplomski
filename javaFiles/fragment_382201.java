List<MyCustomPojo> res = create
    .select(TABLE_A.fields())
    .select(/* all fields in TABLE_B except the ones you don't want */)
    .from(TABLE_A)
    .leftJoin(TABLE_B)
    .on(TABLE_A.MY_CODE.eq(TABLE_B.MY_CODE))
    .fetchInto(MyCustomPojo.class);