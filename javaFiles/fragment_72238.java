String hql="select FT.termId , FT.termName , FT.termCount, FT.feeTermDateses  from FeeTerms FT, FeeTermDates FD where FT.termId = FD.feeTerms.id";

Query query = currentSession.createQuery(hql);
List<Object[]> results = query.getResultList(); 
for (Object[] obj : results) {
    Integer termId = obj[0];
    String termName = obj[1];
    String termCount = obj[2];
    Set<FeeTermDates> feeTermDates  = obj[4];
}