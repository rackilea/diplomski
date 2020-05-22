Binding aBinding = bindingProvider.getBinding();
     List<Handler> handlerChain = aBinding.getHandlerChain();
     handlerChain.add(new SOAPHandler<SOAPMessageContext>() {

       public Set<QName> getHeaders() {
         return new TreeSet<QName>();
       }

       public boolean handleMessage(SOAPMessageContext context) {
        final Boolean outInd = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

        if (outInd.booleanValue()) {
            try {

                context.put(BindingProvider.USERNAME_PROPERTY, user);
                context.put(BindingProvider.PASSWORD_PROPERTY, password);

            } catch (final Exception e) {
                return false;
            }
        }

        return true;
    }