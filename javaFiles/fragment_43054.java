try {
        if (logger.isDebugEnabled()) {
            logger.debug("Invoking @ExceptionHandler method: " + exceptionHandlerMethod);
        }
        exceptionHandlerMethod.invokeAndHandle(webRequest, mavContainer, exception, handlerMethod);
    }
    catch (Exception invocationEx) {
        if (logger.isErrorEnabled()) {
            logger.error("Failed to invoke @ExceptionHandler method: " + exceptionHandlerMethod, invocationEx);
        }
        return null;
    }