private void doAuthenticationRedirect(HttpServletRequest request, HttpServletResponse response) throws Exception {
  AuthnRequest authnRequest = buildAuthnRequestObject(); // assume this is your method

  // No response adapters needed anymore; the response now gets set directly on the encoder
  response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);

  // check your makeSamlMessageContext() method to see if any other properties on messageContext need to be set here
  MessageContext<SAMLObject> messageContext = new MessageContext<>();
  messageContext.setMessage(authnRequest);

  // This moved out of the Configuration class
  XMLObjectBuilderFactory builderFactory = XMLObjectProviderRegistrySupport.getBuilderFactory();

  SAMLObjectBuilder<Endpoint> endpointBuilder =
      (SAMLObjectBuilder<Endpoint>) builderFactory.getBuilder(AssertionConsumerService.DEFAULT_ELEMENT_NAME);

  Endpoint samlEndpoint = endpointBuilder.buildObject();
  samlEndpoint.setLocation(dao.loadString((this.getClass().getName() + "_IDPRedirectURL")));

  String uuid = UUIDBuilder.createUUID().toString(); // Assume this is your class

  // RelayState is now set via this helper method, or it can be performed via:
  // messageContext.getSubcontext(SAMLBindingContext.class, true).setRelayState(uuid);
  SAMLBindingSupport.setRelayState(messageContext, uuid);

  // Endpoint is now set via subcontexts
  SAMLPeerEntityContext peerEntityContext = messageContext.getSubcontext(SAMLPeerEntityContext.class, true);
  SAMLEndpointContext endpointContext = peerEntityContext.getSubcontext(SAMLEndpointContext.class, true);
  endpointContext.setEndpoint(samlEndpoint);

  // MessageContext and HttpServletResponse now get set directly on the encoder
  HTTPRedirectDeflateEncoder httpRedirectDeflateEncoder = new HTTPRedirectDeflateEncoder();
  httpRedirectDeflateEncoder.setMessageContext(messageContext);
  httpRedirectDeflateEncoder.setHttpServletResponse(response);
  httpRedirectDeflateEncoder.initialize();
  httpRedirectDeflateEncoder.encode();
}