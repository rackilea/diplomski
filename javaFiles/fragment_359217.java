public JSONObject getCustomer(final String customerId) {
    if (isNull(customerId) || customerId.trim().isEmpty()) {
        return null;
    }
    ...
}