final SiteSalesFigures siteSalesFigures =
dsl.select(
      countDistinct(LINE.TRANSACTION_ID).as("transactionCount"),
      sum(LINE.PROFIT).as("totalProfit"),
      sum(LINE.TOTAL).as("totalSalesAmount"),
      sum(LINE.QUANTITY).as("totalItemsSold"),
      sum(LINE.PROFIT).divide(sum(LINE.TOTAL)).multiply(100).as("profitMarginPercentage"),
      sum(LINE.QUANTITY).divide(countDistinct(LINE.TRANSACTION_ID)).as("averageItemsPerTransaction"),
      sum(LINE.TOTAL).divide(countDistinct(LINE.TRANSACTION_ID)).as("averageSalesTotalPerTransaction"),
      sum(LINE.PROFIT).divide(countDistinct(LINE.TRANSACTION_ID)).as("averageProfitTotalPerTransaction"))
    .from(TRANSACTIONS)
    .join(LINE).on(TRANSACTIONS.TRANSACTION_ID.equal(LINE.TRANSACTION_ID))
    .leftJoin(ITEM).on(LINE.ITEM_ID.equal(ITEM.ITEM_CODE))
    .where(TRANSACTIONS.SITE_ID.equal(siteId))
    .and(TRANSACTIONS.NO_OF_LINES.greaterThan(0))
    .and(TRANSACTIONS.START_TIME
      .between(new Timestamp(reportStartDate.toInstant().toEpochMilli()))
      .and(new Timestamp(reportEndDate.toInstant().toEpochMilli())))
    .and(TRANSACTIONS.TRANSACTION_TYPE_ID.notEqual(cancelledSaleID))
    .fetchOneInto(SiteSalesFigures.class);