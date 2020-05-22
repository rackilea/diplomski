final MetadataExtractor<FCAddress> metadataExtractor = t -> {
    final Map<String, String> metadata = new HashMap<>();
    metadata.put("senderCountryCode", t.getCountryCode());
    if (t.getState() != null) {
       metadata.put("senderState", t.getState());
    }
    metadata.put("senderPostalCode",t.getPostalCode());
    return metadata;
};