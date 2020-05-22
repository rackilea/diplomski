return myAsyncMethod(param1, param2, (result, exc, att) -> {
    try {
        if (exc != null) {
            return handleError(exc); //cleanup resources and invoke parentHandler.complete(null, exc, null)
        } else {
            return handleResult(result);
        }
    } catch (Exception e) {
        return handleError(exc); //cleanup resources and invoke parentHandler.complete(null, exc, null)
    }
});