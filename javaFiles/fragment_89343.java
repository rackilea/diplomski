public Document getDocument(Message message,
                            String base,
                            Map<String, String> params,
                            String ctxUri,
                            EndpointInfo endpointInfo) {
    Document domDocument = super.getDocument(message, base, params, ctxUri, endpointInfo);
    domDocument.getChildNodes(); // Whatever you need to add remove
    return domDocument; // Once modified
}