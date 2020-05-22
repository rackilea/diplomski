private final static Pattern PATTERN_EXTRACT = Pattern.compile(".*code=(.*)$", Pattern.CASE_INSENSITIVE);
private final static String GETCODE_URL = "https://login.live.com/oauth20_authorize.srf?response_type=code&display=touch&client_id=%s&redirect_url=https://login.live.com/oauth20_desktop.srf&scope=office.onenote";

/*
* Step (1) : get a valide code through user interaction
*/
public void requestCode() {

    SwingUtilities.invokeLater(() -> {
        String url = String.format(GETCODE_URL, _the_application_id_);
        browser.load(url);
    });
}

/**
* Called when the browser triggers an event locationChanged()
*/
public void locationChanged() {
    final String location = browser.getUrl();
    Matcher m = PATTERN_EXTRACT.matcher(location);
    if (m.matches() && m.groupCount() == 1) {
        setCode(m.group(1));
    }
}

/**
* Step (2) : get a valid tolken based on the newly aquired code
*/
void setCode(String code) {
    try {

        RequestBody formBody = new FormEncodingBuilder()
                .add("client_id", _the_application_id_)
                .add("redirect_url", TOKEN_REFRESH_REDIRECT_URL)
                .add("client_secret", _the_application_secret_)
                .add("code", code)
                .add("grant_type", "authorization_code")
                .build();

        Request.Builder reqBuilder = new Request.Builder();
        reqBuilder.url(TOKEN_REFRESH_URL);
        reqBuilder.post(formBody);

        Request request = reqBuilder.build();

        final Call call = client.newCall(request);

        // exécution en synchrone
        Response response = call.execute();

        JsonObject refreshTokenResponse = UrlHelper.parseResponse(response);
        final JsonPrimitive at = refreshTokenResponse.getAsJsonPrimitive("access_token");
        if (at != null) {
            setTolken(at.getAsString());
            setStatus(Status.DONE);
            return true;
        }

    } catch (Exception ex) {
        // TODO : add some error handling
        ex.printStackTrace();
    }
}


/**
 * Parse a OneNote HTTP reponse and returns its data as a JSonObject
 *
 * @param response
 *
 * @return
 */
public static JsonObject parseResponse(Response response) {
    final String body;

    try {
        body = response.body().string();
    } catch (IOException ex) {
        throw new InvalidOnenoteContentExcepion("Unable to retrieve response content", ex);
    }

    if (!response.isSuccessful()) {
        if (response.body().contentType().toString().startsWith("application/json")) {
            JsonObject message = ZJsonReader.getInstance().from(body);
            throw new ApiException(message, response.code(), response.message());
        }
        else {
            throw new HttpException(response.code(), response.message());

        }

    }
    if (response.body().contentType().toString().startsWith("application/json")) {
        JsonObject refreshTokenResponse = ZJsonReader.getInstance().from(body);
        return refreshTokenResponse;
    }
    System.err.println(body);
    throw new InvalidOnenoteContentExcepion("Invalid response content :\"" + response.body().contentType().toString() + "\"");
}