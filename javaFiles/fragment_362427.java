StringBuilder sb = new StringBuilder();
sb.append(" SELECT new ").append(ObjectVO.class.getName()).append("(co.someInfo1, co.someInfo2, so1.someInfo )");
sb.append(" FROM ComplexObject co ");
sb.append(" JOIN co.subOject1s so1 ");
sb.append(" LEFT JOIN so1.so2 so2 ");
sb.append(" WHERE so1.id = :idSo1 AND so2 = :someThing");

Query q = em.createQuery(sb.toString());
q.setParameter("idSo1", idSo1);
q.setParameter("someThing", someThing);

List<ObjectVO> listResult = q.getResultList();