private MultivaluedMap<String, String> getPathParameters(String uri, String strUrlTemplate) {

        UriTemplate template = new UriTemplate(strUrlTemplate);
        Map<String, String> parameters = new HashMap<>();
        Boolean value = template.match(uri, parameters);
        return new MultivaluedHashMap(parameters);

    }