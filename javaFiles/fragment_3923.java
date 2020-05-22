enum MyServiceApi {
    UsersApi {
        public MyServiceApiUsersResponse getUsers(MyServiceApiUsersRequest request) {
            return send(getBaseUrl() + "Users/get", request, MyServiceApiUsersResponse.class);
        }

    },  ItemsApi {
        // mutliple function that calls a speicfic URL in the API, and return specifics object based on the call, for example :
        public MyServiceApiItemsResponse getUsers(MyServiceApiItemsRequest request) {
            return send(getBaseUrl() + "Items/get", request, MyServiceApiItemsResponse.class);
        }
    };

    private final Map<String, String> headers = new LinkedHashMap<String, String>();

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(HashMap<String, String> headers) {
        this.headers.clear();
        this.headers.putAll(headers);
    }

    public abstract <T extends IMyServiceApiResponse> T send(String url, IMyServiceApiRequest request, Class<T> to);

    protected String getBaseUrl() {
        return "http://api.mywebsite.com/";
    }
}