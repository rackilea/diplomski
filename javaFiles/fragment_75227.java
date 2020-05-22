@RequestMapping(path="/admin/count",method=RequestMethod.POST)
    public int count(@RequestParam(name="endPoint") final String endPoint) throws IOException, JSONException
    {
        final String URLtoMap = "http://localhost:8080/actuator/metrics/http.server.requests?tag=uri:" + endPoint + "";
        return sendRequestToURL(URLtoMap);
    }