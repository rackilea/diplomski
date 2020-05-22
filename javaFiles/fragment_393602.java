public static <T extends Exception> void handleException(
    T exception,
    String errorMessage
    ) throws T
{
    final String newMessage = errorMessage + "\n " + exception.getMessage();
    LOGGER.error(newMessage);
    T newException = exception;
    try {
        newException = (T)exception.getClass()
                                .getConstructor(new Class[] { String.class, Exception.class })
                                .newInstance(new Object[] { newMessage, exception});
    } catch (Exception) {
    }
    throw newException;
}