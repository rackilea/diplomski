public class CustomRollingFileAppender extends RollingFileAppender
{
    @Override
    protected void subAppend(LoggingEvent event)
    {
        LoggingEvent modifiedEvent = new LoggingEvent(event.getFQNOfLoggerClass(), event.getLogger(),
                event.getTimeStamp() + StaticVariables.timeDifference, event.getLevel(), event.getMessage(), event.getThreadName(),
                event.getThrowableInformation(), event.getNDC(), event.getLocationInformation(), event.getProperties());

        super.subAppend(modifiedEvent);
    }
}