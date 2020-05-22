public List<MyEntity> findMyDumbEntities(long id) {        
          QMyEntity qMyEntity = QMyEntity.myEntity;
          MyEntity myFirstEntity = new JPAQuery(entityManager).from(qMyEntity).where(qMyEntity.id.eq(id)).uniqueResult(qMyEntity);
          MyEntity mySecondEntity = new JPAQuery(entityManager).from(qMyEntity).where(qMyEntity.id.eq(id+1)).uniqueResult(qMyEntity);

          return Arrays.asList(myFirstEntity, mySecondEntity);        
}