public static boolean validate(LoggingContext loggingContext)
    throws ValidationException
{
    checkAndThrow(loggingContext.getApplicationlevel(), "Applicationlevel");
    checkAndThrow(loggingContext.getAuditlevel(), "Auditlevel");
    checkAndThrow(loggingContext.getBillinglevel(), "Billinglevel");
    ...
    return true;
}