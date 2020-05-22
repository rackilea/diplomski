Transaction tx = null;
    try {
        tx = session.beginTransaction(); 
        services.entity.saveInstance(secQuestions);
        tx.commit();
    }
    catch(Exception e) {
        tx.rollback();
        session.clear();
        if(e instanceof org.hibernate.exception.ConstraintViolationException){
            Transaction tx1 = session.beginTransaction();
            userRegistrationRequest.requestProcessed = true
            infoMsg = userRegistrationRequest.infoMessage+' Exception: '+e.message
            userRegistrationRequest.infoMessage = infoMsg
            entityService.update(userRegistrationRequest);
            tx1.commit();
            logger.info("Caught BaseApplicationException "+e.message)
            return;
     }
}