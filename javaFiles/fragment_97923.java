public List<MyEntity> findMyDumbEntities(long id) {    
      QMyEntity qMyEntity = QMyEntity.myEntity;
      JPAQuery jpaQuery = new JPAQuery(entityManager);
      MyEntity myFirstEntity = jpaQuery.from(qMyEntity).where(qMyEntity.id.eq(id)).uniqueResult(qMyEntity);
      MyEntity mySecondEntity = jpaQuery.from(qMyEntity).where(qMyEntity.id.eq(id+1)).uniqueResult(qMyEntity);

      return Arrays.asList(myFirstEntity, mySecondEntity);    
}