public Boolean existsOrNot (DTOAny i) {
    Query q = getSession().             
    createQuery("select 1 from DTOAny t where t.key = :key");
        q.setString("key", i.getKey() );
    return (q.uniqueResult() != null);
}