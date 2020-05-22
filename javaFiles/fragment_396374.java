String[] roles = {"OPS", "RM1", "RM", "ARM"};//list of roles
String[] template_type = {"MAIL", "PUSH", "PUSH", "PUSH"};//list of template_type

StringBuilder query = new StringBuilder();
query.append("SELECT * FROM TB_BAMI_TEMPLATES WHERE referral_queue = :referralQueue AND TXN_TYPE = :txnType "
        + "AND REFERRAL_RSN = :reffralRsn AND (");

String del = "";
for (int i = 0; i < roles.length; i++) {
    query.append("(ROLE = '").append(roles[i]).append("' AND TEMPLATE_TYPE = '").append(template_type[i]).append("')");
    del = "OR";
    query.append(del);
}
query.append("(ROLE = 'ALL' AND (TEMPLATE_TYPE = 'PUSH' OR TEMPLATE_TYPE = 'MAIL')))AND ACTION = :action");

System.out.println(query.toString());

//Create your query, and set parameters then get your results
Query q = em.createNativeQuery(query.toString());
q.setParametter("referralQueue", referralQueue);
q.setParametter("txnType", txnType);
q.setParametter("reffralRsn", reffralRsn);
q.setParametter("action", action);

List<Type> = q.getResulList();