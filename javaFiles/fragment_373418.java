String hql = "select t, count(1) from BlogArticle a inner join a.tags t group by t";
List tagCounts = createQuery( hql ).list();

Iterator itr = tagCounts.iterator();
while ( itr.hasNext() ) {
    Object[] tagCount = (Object[]) itr.next();
    String tag = (String) tagCount[0];
    Long count = (Long) tagCount[1];
}