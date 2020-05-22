public void funcA(String str) {
  StringBuilder sql = new StringBuilder();
  sql.append("select fieldA from tableA where fieldB like :searchKey");

  ...

  session.createSQLQuery(sql.toString())
  .addScalar("fieldA", StandardBasicTypes.STRING)
  .setParameter("searchKey", "%" + str + "%");

  ...
}