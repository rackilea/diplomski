public List<Booking> getInventory(){
    Session session = sessionFactory.openSession();
    session.beginTransaction();

    Query query = session.createQuery("select booking from Booking booking");

    List<Booking> invList = (List<Booking>) query.getResultList();

    return invList;
}