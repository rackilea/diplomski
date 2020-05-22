private List<Header> mergeHeaders(final List<Header> defHeaders, final List<Header> ovrdHeaders) {
    final Map<String, Header> headersMap = new LinkedHashMap<String, Header>();

    for (final Header defHeader : defHeaders) {
        headersMap.put(defHeader.getName().toLowerCase(), defHeader);
    }

    for (final Header ovrdHeader : ovrdHeaders) {
        headersMap.put(ovrdHeader.getName().toLowerCase(), ovrdHeader);
    }

    return new ArrayList<Header>(headersMap.values());
}