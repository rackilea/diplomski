catch (MailSendException e){
        logger.error("MailSendException found.",e);
        Exception[] exceptionArray = e.getMessageExceptions();
        e.getFailedMessages();
        boolean isSMTPAddressFailedException = false;
        for(Exception e1 : exceptionArray){
            if(e1 instanceof SendFailedException){
                Exception e2 = ((SendFailedException)e1).getNextException();
                if(e2 instanceof SMTPAddressFailedException){
                    logger.error("Caught SMTPAddressFailedException. Invalid email id of User/Dealer",e2);
                    utilityService.formatBasicResponseWithMessage(response, ResponseCodes.INVALID_EMAILID, serviceRequestVO.getLanguageId());
                    isSMTPAddressFailedException=true;
                    break;
                }
            }
        }