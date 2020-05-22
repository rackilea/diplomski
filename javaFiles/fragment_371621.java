public void saveFriend(Friend friend, String rUser) 
{
   Session session = sessionFactory.getCurrentSession();
   Transaction t = session.beginTransaction();
   friend.setId(1);
   friend.setUsername(rUser);
   friend.setAddedDate(new Date());
   session.saveOrUpdate(friend);

   friend.setId(2):
   friend.setUsername(rUser);
   friend.setAddedDate(new Date());
   session.saveOrUpdate(friend);

   if(someCondition) {
      t.commit();
   }
   else{
      t.rollback();
   }
}