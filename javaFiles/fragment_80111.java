void addData(Something something, Data data){
    //Something similar can be used for batch insert
    data.setSomething(something);
    em.persist(data);
}

List<Data> findData(Something something, MyFilter filter){
    // use a NamedQuery with parameters populated by something and your filters
    return em.getResultList();
}

Long countData(Something something){
    // use a 'SELECT COUNT(*) FROM Data d WHERE d.something = :something' NamedQuery 
    return em.getSingleResult;
}