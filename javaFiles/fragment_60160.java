EntityTransaction tr = entityManager.getTransaction();
 tr.begin();

 Uposlenik uposlenik = entityManager.find(Uposlenik.class, 1);
 if(uposlenik == null){
    throw new RuntimeException("The record does not exist");
    tr.rollback();
 }
 uposlenik.updatePrice(123);
 ......

 tr.commit();