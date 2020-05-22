public class API {
    private String endpoint = "https://api.minesca.pe";
    private Context context;
    private String args;
    private HTTPRequest.StatusCode statusCode;
    private String jsonString;

    public API(Context context, String args) throws JSONException {
        this.context = context;
        this.args = args;
        fetch();
    }

    private void fetch() throws JSONException {
        HTTPRequest httpRequest = NetworkStack.getInstance(context).performRequest(endpoint + args, Request.Method.GET);
        statusCode = httpRequest.getStatusCode();
        if (statusCode == HTTPRequest.StatusCode.FOUND) {
            jsonString = httpRequest.getOutput();
        }
    }

    public JSONObject getJsonObject() {
        try {
            return new JSONObject(jsonString);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public JSONArray getJsonArray() {
        try {
            return new JSONArray(jsonString);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public HTTPRequest.StatusCode getStatusCode() {
        return statusCode;
    }
}

private JSONObject getJsonObjectFromAPI() throws APIError, JSONException {
        API api = new API(context, getAPIEndpoint());

        if (api.getStatusCode() == StatusCode.FOUND) {
            return api.getJsonObject();
        } else {
            throw new APIError("Unexpected response from the server.");
        }
    }
    private JSONArray getJsonArrayFromAPI() throws APIError, JSONException {
        API api = new API(context, getAPIEndpoint());

        if (api.getStatusCode() == StatusCode.FOUND) {
            return api.getJsonArray();
        } else {
            throw new APIError("Unexpected response from the server.");
        }
    }