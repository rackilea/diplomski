public List<LookUpJobs> getJobsList(){
    return (List<LookUpJobs>)
    getSession().createSQLQuery("select "
            + "j.type type,"
            + " j.description process,"
            + " j.value schedTime,"
            + " from tableName j inner join tableName m on j.type = m.value")
        .addScalar("type",Hibernate.STRING)
        .addScalar("process",Hibernate.STRING)
        .addScalar("schedTime",Hibernate.STRING)
        .setResultTransformer(Transformers.aliasToBean(LookUpJobs.class))
        .list();
}