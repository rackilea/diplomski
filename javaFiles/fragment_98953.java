RetryWsCall retryWsCall = new RetryWsCall();
MyObject result = retryWsCall.callWs(
        new RetryWsCall.RetryCallInterface() 
                {
                  @Override
                  public Integer RetryCallMethod()
                  {
                    return anotherWsPortType.callSomeOtherMethod(arg);
                  }
                },
        numberOfAttempts
);