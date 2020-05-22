String hql = "select w, s.simpleWebContentData 
    from WebContentDefinition w, SimpleWebContent s 
    where ...";
Query query = session.createQuery(hql);
query.setParameter("contentId", contentId);
query.setParameter("siteId", siteId);
List<Object[]> results = query.list();
if (results != null && !results.isEmpty()) {
    WebContentDefinition w = (WebContentDefinition)results[0];
    String data = (String)results[1];
}