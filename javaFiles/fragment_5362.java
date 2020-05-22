@Entity @Indexed
public class Child {
...


Query searchQuery = queryBuilder.keyword().onField("parent.name").matching("test").createQuery();
FullTextQuery fullTextQuery = fullTextEntityManager.createFullTextQuery(searchQuery, Child.class);
fullTextQuery.setProjection("name");