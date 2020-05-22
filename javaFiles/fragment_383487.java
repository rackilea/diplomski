List<Parent> parentList = session
        .createQuery("from Parent p left join fetch p.children c" +
                     " where p.status = 'COMPLETE' " + 
                     " and (c.key = 'FIRST_KEY' or c.key = 'SECOND_KEY')")
        .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY)
        .list();

for(Parent parent:parentList) {
    System.out.println(parent);;
}