try {
  em.getTransaction().begin(); 
  ..do what you need to do..
  em.getTransaction().commit();
} catch(Exception ex) {
  em.getTransaction().rollback();
  throw ex; // let upper methods know this did not go well
}