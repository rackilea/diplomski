// Hold the ID of the inserted audit record.
private Integer rowId; 

protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
    ContentCachingRequestWrapper wrappedRequest = new ContentCachingRequestWrapper(request);

    filterChain.doFilter(wrappedRequest, response);
    Integer status = response.getStatus();

    String query = "UPDATE AUDIT_LOG SET RESPONSE = :responseCode where id = :rowId";
    SqlParameterSource parameters = new MapSqlParameterSource()
        .addValue("responseCode", status)
        .addValue("rowId", rowId);

    namedParameterJdbcTemplate.update(query, parameters);
}


@EventListener
public void auditEventHappened(AuditApplicationEvent auditApplicationEvent) {

    AuditEvent auditEvent = auditApplicationEvent.getAuditEvent();

    ServletRequestAttributes sra = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
    HttpServletRequest req = sra.getRequest();

    String query = "INSERT INTO AUDIT_LOG (USERNAME,AUTH_STATUS,REQUEST_IP,SERVER_IP,REQUEST_URL,RESPONSE_CODE) VALUES (:1,:2,:3,:4,:5,:6)";
    KeyHolder holder = new GeneratedKeyHolder(); // Required to get the inserted record ID from the database. 

    SqlParameterSource parameters = new MapSqlParameterSource()
            .addValue("1", auditEvent.getPrincipal())
            .addValue("2", auditEvent.getType())
            .addValue("3", req.getRemoteAddr())
            .addValue("4", req.getLocalAddr())
            .addValue("5", req.getRequestURI())
            .addValue("6", null);      

    // Issue the statement to the database. Pull back the ID column of inserted record. Store in keyholder.
    namedParameterJdbcTemplate.update(query, parameters, holder, new String[]{"ID"});
    rowId = holder.getKey().intValue(); // Get the inserted ID from the keyholder, set globally for doFilterInternal which is about to trigger. 

}