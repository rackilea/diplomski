List<NameValuePair> convertParameters(Map<String, Double> parameters) {
    List<NameValuePair> result = new ArrayList<NameValuePair>();

    for (Entry<String, Double> entry : parameters.entrySet()) {
        result.add(new BasicNameValuePair(entry.getKey(), entry.getValue().toString()));
    }

    return result;
}