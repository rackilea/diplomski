public Optional<String> getMarketplaceCustomerIdByUsername(String username) {
    return Optional.ofNullable(username) // if username is null empty
            .filter(name -> !name.isEmpty()) // empty string returns filtered out
            .map(name -> apiClient.getMarketplaceData(getKeys(name))) // handles 'null' calue returned
            .map(marketplaceData -> marketplaceData.getObjects().get(0).getCustomerId()); // here as well
}