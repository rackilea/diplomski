/**
 * Returns the counts, totals and averages of the states by their currency, period and status.
 */
@Query(value = "select i.currency, date(p), i.status, count(id), sum(coalesce(i.total, 0)), avg(coalesce(i.total, 0)) " +
    "from generate_series(date_trunc(:period, cast(:from as timestamp)), date_trunc(:period, cast(:to as timestamp)) + cast('1 ' || :period as interval), cast('1 ' || :period as interval)) p " +
    "inner join invoice i on i.due_date >= p and i.due_date < p + cast('1 ' || :period as interval) " +
    "where issuer_id = :issuerId and type = :type and (:recipientId = 0 or recipient_id = :recipientId) and type = :type " +
    "group by i.currency,  date(p), i.status " +
    "order by i.currency, date(p), i.status", nativeQuery = true)
List<Object[]> getIssuerStatementTotalsByCurrencyPeriodAndStatus(
    @Param("issuerId") long issuerId,
    @Param("recipientId") long recipientId,
    @Param("type") String statementType,
    @Param("from") String from,
    @Param("to") String to,
    @Param("period") String period);