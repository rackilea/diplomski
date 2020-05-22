final Query query = sessionFactory.getCurrentSession().createQuery(hql);

final QueryTranslatorFactory ast = new ASTQueryTranslatorFactory();
final QueryTranslatorImpl newQueryTranslator = (QueryTranslatorImpl) ast.createQueryTranslator(queryId, query.getQueryString(), Collections.EMPTY_MAP, (SessionFactoryImplementor) sessionFactory);
newQueryTranslator.compile(null, false);
sql = newQueryTranslator.getSQLString();