try {

            session.beginTransaction();
            session.save(soDtls);
           //Creating pdf file (itext) using SoDtls object 

            session.getTransaction().commit();

        }}catch (Exception ex) {
            deleteFileIfExists();
            session.getTransaction().rollback();  //------> getting error at this line
            throw ex;
        }finally{
            if(session != null){
                session.close();
            }
        }