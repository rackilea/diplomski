if (sessionFactory!= null && !sessionFactory.isClosed()) {
            if(session != null){
             session.close();
            }
            sessionFactory.close();
       }