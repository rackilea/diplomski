catch(RestException restException){
        log.info("RestException -:", restException);
        restException.printStackTrace();
        baseDto.setStatusCode(baseDto.getStatusCode());
        throw restException;
    }