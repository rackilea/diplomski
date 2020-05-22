class UrlBuilder {

    private String path;

    private Map<String, String> parameters = new LinkedHashMap<String, String>();

    public UrlBuilder path(String path) {
        this.path = path;
        return this;
    }

    public UrlBuilder parameter(String param, String value) {
        parameters.add(param, value);
        return this;
    }


    public String build() {
        String paramsString = "";

        for (Map.Entry<String, String> entry: parameters.entrySet()) {
            if (paramsString.isEmpty()) {
                paramsString += "?";
            }
            paramsString += params.getKey() + "=" + params.getValue();
        }

        return path + paramsString;
    }

}