public static <T extends Exception> void handleException(
    T exception,
    String errorMessage
    ) throws T
{
    LOGGER.error( errorMessage + "\n " + exception.getMessage() );
    throw exception;
}