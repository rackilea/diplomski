...
    try {
        /* game is playing() */
    }
    catch (MyGameException gameException) {        
       logging.log(gameException.log());        
       sendErrorCodeToTheUser(gameException);        
    }