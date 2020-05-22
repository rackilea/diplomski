Query q = session.createQuery("select e.id, e.firstName from Employee e");
     List<Object[]> employees= (List<Object[]>)q.list();
     for(Object[] employee: employees){
         Integer id = (Integer)employee[0];
         String firstName = (String)employee[1];
         .....
     }