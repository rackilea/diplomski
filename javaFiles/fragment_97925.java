@Override
public List<Article> findAll() {
      return jpaQuery().from(article).fetchAll().list(article);
}

public Article findById(@Nonnull final long id) {
      return jpaQuery().from(article).where(article.id.eq(id)).uniqueResult(article);
}