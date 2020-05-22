public List<ReportSewing> getReport(Date reportDate) {
     return session.getCurrentSession()
         .createQuery("from ReportSewing where DATE(reportDate) = :reportDate")
         .setParameter("reportDate", reportDate)
         .list();
}