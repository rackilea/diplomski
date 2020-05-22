Service1 service1 = new Service1();
        IService1 iService1 = service1.getBasicHttpBindingIService1();

        BindingProvider bindingProvider = (BindingProvider) iService1;
        final Binding binding = bindingProvider.getBinding();
        List<Handler> handlerList = binding.getHandlerChain();

        if (handlerList == null) {
            handlerList = new ArrayList<Handler>();
        }

        handlerList.add(new HeaderHandler());
        binding.setHandlerChain(handlerList);
        ServiceResponse serviceResponse = iService1.callServiceMethod1(serviceRequest);