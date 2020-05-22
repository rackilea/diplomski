List<MyCustomPojo> res = create
    .select(TABLE_A.fields())
    .select(TABLE_B.fields())
    .select(TABLE_A.MY_CODE)
    .from(TABLE_A)
    .leftJoin(TABLE_B)
    .on(TABLE_A.MY_CODE.eq(TABLE_B.MY_CODE))
    .fetchInto(MyCustomPojo.class);