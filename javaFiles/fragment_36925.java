@Scheduled(fixedRate = 30 * SECOND)
public void sendMailsInQueue()
{
    List<EmailPreparator> queue = emailQueueHandler.getQueue();
    int mailsSent = queue.size();
    int mailsFailed = 0;
    for(EmailPreparator preparator : queue)
    {
        try {
            // And finally send the mail
            emailSenderService.sendMail(preparator);
        }
        // If mail sending is not activated, mail sending function will throw an exception,
        // Therefore we have to catch it and only throw it back if the email was really supposed to be sent
        catch(Exception e)
        {
            mailsSent --;
            // If we are not in test Env
            if(!SpringConfiguration.isTestEnv())
            {
                mailsFailed ++;
                preparator.getEmail().setTriggeredExceptionName(e.getMessage()).update();

                // This will log the error into the database and eventually
                // print it to the console if in LOCAL env
                new Error()
                        .setTriggeredException(e)
                        .setErrorMessage(e.getClass().getName());
            }
            else if(SpringConfiguration.SEND_MAIL_ANYWAY_IN_TEST_ENV || preparator.isForceSend())
            {
                mailsFailed ++;
                throw new EmailException(e);
            }
        }
    }

    log.info("CRON Task - " + mailsSent + " were successfuly sent ");
    if(mailsFailed > 0)
        log.warn("CRON Task - But " + mailsFailed + " could not be sent");
}