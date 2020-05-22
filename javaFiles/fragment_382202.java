List<MyCustomPojo> res = create
    .select()
    .from(TABLE_B)
    .rightJoin(TABLE_A)
    .on(TABLE_A.MY_CODE.eq(TABLE_B.MY_CODE))
    .fetchInto(MyCustomPojo.class);