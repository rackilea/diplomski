...

@Autowired
private List<HandlerMapping> handlerMappings;

for (HandlerMapping handlerMapping : handlerMappings) {
  HandlerExecutionChain handlerExecutionChain = handlerMapping.getHandler(request);
  if (handlerExecutionChain != null) {
     // handlerExecutionChain.getHandler() is your handler for this request
  }
}