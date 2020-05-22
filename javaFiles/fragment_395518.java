JSONObject response = null;
try {
    response = /* make network call */;
} catch (final Exception e) {
    LOG.error("---- bar message ---");
    throw new SvcException("failed to connect over network");
}

if (!response.getBoolean(SUCCESS)) {
    LOG.error("--- foo message ---");
    throw new Exception("message replied with error");
}