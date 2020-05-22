String jpql = "select event from Venue venue"
              + " inner join venue.events event"
              + " where event.date < :now"
              + " order by event.date asc";
List<Event> pastEvents = em.createQuery(jpql, Event.class)
                           .setParameter("now", new Date())
                           .getResultList();