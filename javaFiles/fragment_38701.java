@Override
public RequestMappingHandlerMapping requestMappingHandlerMapping() {
    final RequestMappingHandlerMapping requestMappingHandlerMapping = super.requestMappingHandlerMapping();
    requestMappingHandlerMapping.setRemoveSemicolonContent(false); // <<< this
    return requestMappingHandlerMapping;
}