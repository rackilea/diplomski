public ReturnType registrar(RequestType request)
    {
        // That's the call that didn't worked. Registrar is the name of the method
    // return serviceCLient.registrar(user, password, request);

        try {
            JAXBContext context = JAXBContext.newInstance(RequestType.class, ReturnType.class, 
                    request.geGenericContent().getClass());

            Dispatch<Object> registrarDispatch = service.createDispatch(
                    RegistroElectronico.RegistroElectronicoSoap, context, Mode.PAYLOAD);

            registrarDispatch.getRequestContext().put(Dispatch.SOAPACTION_USE_PROPERTY, Boolean.TRUE );
            registrarDispatch.getRequestContext().put(Dispatch.SOAPACTION_URI_PROPERTY, "http://pixelware.com/RegistroTelematico/Registrar" );

            Registrar registrar = new Registrar();
            registrar.setLogin(this.user);
            registrar.setPassword(this.password);
            registrar.setSolicitud(request);

            RegistrarResponse response = (RegistrarResponse) registrarDispatch.invoke(registrar);
        return response.getRegistrarResult();


        } catch (JAXBException e) {
            throw new RuntimeException(e);
        } 
    }