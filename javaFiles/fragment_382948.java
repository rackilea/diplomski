query = session.createQuery("from Class where id = 5");
List list=query.list();
if(list.size()!=0)
 {
   ClassName obj = (ClassName)list.get(0);
   session.delete(obj);
  }