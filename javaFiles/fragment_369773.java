final MetadataExtractor<FCAddress> metadataExtractor = t -> {
    final Map<String, String> metadata = new HashMap<>();
    metadata.put("senderCountryCode", t.getCountryCode());

    // Here you create a not useful object that can be replaced with a simple if
    Optional<String> senderState = Optional.ofNullable(t.getState());

    // Here you create a second not necessary object because a lambda
    // espression is an instance of an anonimous class implementing
    // the corresponding interface
    senderState.ifPresent(() -> 
         metadata.put("senderState", t.getState()
    );
    metadata.put("senderPostalCode",t.getPostalCode());
    return metadata;
};