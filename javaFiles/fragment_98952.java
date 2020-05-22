RetryWsCall retryWsCall = new RetryWsCall();
int result = retryWsCall.callWs(
        new RetryWsCall.RetryCallInterface() 
                {
                  @Override
                  public Integer RetryCallMethod()
                  {
                    return wsPortType.callMethod(arg1, arg2);
                  }
                },
        numberOfAttempts
);