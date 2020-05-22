public List<Audit> getAudits(Integer branchId, Integer locationId, Date fromDate, Date toDate, int first, int count, String sortProperty, boolean ascending) {

    // columns renamed to match sort properties and hibernate mapping
    StringBuilder query = new StringBuilder(
        "SELECT AUD_Number AS number,"
        + " AUD_Number_REL AS relationNumber,"
        + " AUD_Name_REL AS relationName,"
        + " AUD_Date AS date,"
        + " FROM audit WHERE 1");
        if (branchId!= null) {
            query.append(String.format(" AND AUD_Number_BRN = %s", branchId));
        }
        if (locationId!= null) {
            query.append(String.format(" AND AUD_Nummer_LOC = %s", locationId));
        }
        if (fromDate != null) {
            query.append(String.format(" AND AUD_Date >= %s", DateConverter.dateToSql(fromDate)));
        }
        if (toDate != null) {
            query.append(String.format(" AND AUD_Date <= %s", DateConverter.dateToSql(toDate)));
        }
        query.append(String.format(" ORDER BY %s %s", sortProperty, ascending ? "ASC" : "DESC"));
        query.append(String.format(" LIMIT %s, %s", first, count));
        return (List<Audit>) getSession().createSQLQuery(query.toString()).addEntity(Audit.class).list();
}