ResultQuery<?> query(String bizDate, Field<?> sortField, SortOrder sortOrder, int limitOffset, int limitRows) {
    return context.selectFrom("table1")
                  .where(field("report_date").eq(bizDate))
                  .orderBy(sortField.sort(sortOrder)
                  .limit(limitOffset, limitRows));
}