/**
  * Our HandlerMapping goes here
  */
HandlerMapping handlerMapping = getHandler(request);

HandlerExecutionChain handlerExecutionChain = handlerMapping.getHandler(request);

for(HandlerInterceptor interceptor: handlerExecutionChain.getInterceptors) {
    interceptor.preHandle(request, response, handlerExecutionChain.getHandler());
}

/**
  * Our CustomController goes here
  */
Object handler = handlerExecutionChain.getHandler();

/**
  * Our CustomHandlerAdapter goes here
  */
HandlerAdapter handlerAdapter = getHandlerAdapter(handler);

ModelAndView mav = handlerAdapter.handle(request, response, handler);

for(HandlerInterceptor interceptor: handlerExecutionChain.getInterceptors) {
    interceptor.postHandle(request, response, handlerExecutionChain.getHandler());
}