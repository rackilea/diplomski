public <T> T insertarPersona(Class<T> responseType, String nombre, String edad) throws ClientErrorException {
    WebTarget = webTarget = client.target(BASE_URI).path("Personas");
    String[] queryParamNames = new String[]{"nombre", "edad"};
    String[] queryParamValues = new String[]{nombre, edad};
    ;
    javax.ws.rs.core.Form form = getQueryOrFormParams(queryParamNames, queryParamValues);
    javax.ws.rs.core.MultivaluedMap<String, String> map = form.asMap();
    for (java.util.Map.Entry<String, java.util.List<String>> entry : map.entrySet()) {
        java.util.List<String> list = entry.getValue();
        String[] values = list.toArray(new String[list.size()]);
        webTarget = webTarget.queryParam(entry.getKey(), (Object[]) values);
    }
    return webTarget.request().post(null, responseType);
}


public <T> T consultarEdad(Class<T> responseType, String nombre) throws ClientErrorException {
    WebTarget = webTarget = client.target(BASE_URI).path("Personas");
    String[] queryParamNames = new String[]{"nombre"};
    String[] queryParamValues = new String[]{nombre};
    ;
    javax.ws.rs.core.Form form = getQueryOrFormParams(queryParamNames, queryParamValues);
    javax.ws.rs.core.MultivaluedMap<String, String> map = form.asMap();
    for (java.util.Map.Entry<String, java.util.List<String>> entry : map.entrySet()) {
        java.util.List<String> list = entry.getValue();
        String[] values = list.toArray(new String[list.size()]);
        webTarget = webTarget.queryParam(entry.getKey(), (Object[]) values);
    }
    return webTarget.request(javax.ws.rs.core.MediaType.TEXT_HTML).get(responseType);
}