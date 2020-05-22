try {
            JPA.em().persist(newuser);
        }
        catch(PersistenceException pe){
            //the code for the exception
        }