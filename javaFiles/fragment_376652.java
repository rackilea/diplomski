public static class EnrichedRequestBuilder() {
    private EnrichedRequest enrichedRequest:
    private BasicRequest basicRequest:
    private GeoData geoData;
    private UserAgentData userAgentData;

    public EnrichedRequestBuilder enrichedRequest(EnrichedRequest e) {
        this.enrichedRequest = e;
        return this;
    }

    public EnrichedRequestBuilder basicRequest(BasicRequest e) {
        this.basicRequest = e;
        return this;
    }

    public EnrichedRequestBuilder build() {
        return new EnrichedRequestBuilder(this);
    }


}

new EnrichedRequestBuilder().basicRequest(b).enrichedRequest(e).build();