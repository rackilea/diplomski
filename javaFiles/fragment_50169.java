catch (UncheckedTimeoutException e) {
    String errorMsg = String.format("TIMEOUT for RunGeneralPersonalisation() execution time has exceeded maximum limit of: [%s] ms", timeout);
    ErrorLogger.error(errorMsg, e);
    com.thehutgroup.personalisation.jobs.result.GeneralPersonalisationResult result = generalPersonalisationHandler.returnAvailableResults();
    generalPersonalisationHandler.shutdown();  // possible problem !!!
    return transformAvailableResults(result);
}