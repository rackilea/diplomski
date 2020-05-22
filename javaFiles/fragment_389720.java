AddressingFeature feature = new AddressingFeature(true, false);
MyService proxy = service.getMyService(feature);
BindingProvider bindingProvider = (BindingProvider) proxy;

List<Handler> handlerChain = new ArrayList<Handler>();
//Add a handler to the handler chain
handlerChain.add( new PasswordDigestHeaderHandler() );
Binding binding = bindingProvider.getBinding();
binding.setHandlerChain(handlerChain);

// Add these two lines, to point to the remote service
Map<String, Object> context = bindingProvider.getRequestContext();
context.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, REMOTE_SERVICE_ENDPOINT);

threadLocalClient.set(proxy);