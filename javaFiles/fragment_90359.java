String query = "SELECT o FROM EntityClient o " + 
                "WHERE o.birthDate = :birthDate";
List<EntityClient> list = 
    entityManager.createQuery(query, EntityClient.class)
                 .setParameter("birthDate", new DateTime("1966-07-21"))
                 .getResultList()