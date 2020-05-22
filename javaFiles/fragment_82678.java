// Person class have only trips associated with that person
String jpql1 = "SELECT p.trips FROM Person p WHERE p.id = 1";
List<Trip> trips = em.createQuery(jpql1, Trip.class)
                     .getResultList();

// the code can look at the Trips to find out the trip_no
String jpql2 = "SELECT t.trip_no FROM Trip t JOIN Person p " +
               "WHERE p.id = :id AND t.state = :state";
List<Long> trip_nos = em.createQuery(jpql2, Long.class)
                        .setParameter("id", 1)
                        .setParameter("state", "MN")
                        .getResultList();