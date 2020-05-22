MainPk id = new MainPk();
id.setKeyOne( someValue );

List<YourEntity> results = session
       .createQuery( "FROM YourEntity e WHERE e.id = :id" )
       .setParameter( "id", id )
       .getResultList();