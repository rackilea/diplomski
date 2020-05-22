String queryString = "select p.name, t.points from Tournament t," +
            " Player p where t.player_id=p.id " +
            "and t.id= :id_tournament";

Query query = this.entityManager.createQuery(queryString);
query.setParameter("id_tournament", 1);
List results = query.getResultList();