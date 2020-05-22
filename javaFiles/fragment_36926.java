@After
 public void downUp() throws Exception
 {
    proceedMailQueueManuallyIfNotAlreadySent();
    logger.debug("After Test");

    RequestHolder requestHolder = securityContextBuilder.getSecurityContextHolder().getRequestHolder();

    // We check mails sending if some were sent
    if(requestHolder.isExtResultsSent())
    {
        for(ExtResults results : requestHolder.getExtResults())
        {
            ExtSenderVerificationResolver resolver =
                    new ExtSenderVerificationResolver(
                            results,
                            notificationParserService
                    );
            resolver.assertExtSending();
        }
  }
  // Some code


}

protected void proceedMailQueueManuallyIfNotAlreadySent()
{
    if(!mailQueueProceeded)
    {
        mailQueueProceeded = true;
        scheduler.sendMailsInQueue();
    }
}