cq.orderBy(
  qb.selectCase(root.get("myNumberField"))
    .when(qb.literal(2), qb.literal(1))
    .when(qb.literal(5), qb.literal(2))
    .when(qb.literal(1), qb.literal(3))
    .when(qb.literal(10), qb.literal(4))
    .when(qb.literal(3), qb.literal(5))
    .otherwise(qb.literal(6))
    .getExpression()
    .asc());