for (HandlerMapping handlerMapping : applicationContext.getBeansOfType(HandlerMapping.class).values()) {
  HandlerExecutionChain handlerExecutionChain = handlerMapping.getHandler(request);
  if (handlerExecutionChain != null) {
     // handlerExecutionChain.getHandler() is your handler for this request
  }
}