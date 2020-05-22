private InputStream retrieveRecording(String accountSid, String authToken, String recordingSid) {
    Twilio.init(accountSid, authToken);
    Recording recordingToRetrieve = Recording.fetch(accountSid, recordingSid).execute();
    String uri = recordingToRetrieve.getUri();
    String mp3Uri = uri.replace(".json", ".mp3");
    Request request = new Request(
            HttpMethod.GET,
            TwilioRestClient.Domains.API,
            mp3Uri,
            accountSid);
    Response mp3response = Twilio.getRestClient().request(request);
    if (mp3response == null) {
        throw new ApiConnectionException("Recording media fetch failed: Unable to connect to server");
    } else if (!TwilioRestClient.SUCCESS.apply(mp3response.getStatusCode())) {
        RestException restException = RestException.fromJson(mp3response.getStream(), Twilio.getRestClient().getObjectMapper());
        if (restException == null) {
            throw new ApiException("Server Error, no content");
        }

        throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null);
    }
    return mp3response.getStream();
}