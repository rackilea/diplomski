public Criteria applyPaginationCriteria(ClientSearchCriteria searchCriteria){
    Long recordsPerPage = searchCriteria.getRecordsPerPage();
    if (recordsPerPage >= 0L) {
        criteria.setFirstResult((int) (searchCriteria.getPageNo() * recordsPerPage - recordsPerPage));
        criteria.setMaxResults(recordsPerPage.intValue());
    }
     return criteria;
}