public static ResponsesCollector implements AsyncHandler<HelloResponse> {
   private Map<String, String> responses = new ConcurrentHashMap<>();
   @Override
   public void handleResponse(Response<HelloResponse> res) {
      responses.put(res.get().getReturn(), res.get().getReturn());
   }
   public Map<String, String> getResponses() {
      return responses; 
   }
}


@Override
public String businessMethod() {

    try {
        ResponsesCollector responsesCollector = new ResponsesCollector()

        AdapterWS_Service serviceAdapter = new AdapterWS_Service(new URL(ADAPTER_1_URL));
        AdapterWS adapter = serviceAdapter.getAdapterWSPort();

        adapter.helloAsync("", responsesCollector);

        serviceAdapter = new AdapterWS_Service(new URL(ADAPTER_2_URL));
        adapter = serviceAdapter.getAdapterWSPort();

        adapter.helloAsync("", responsesCollector);

    } catch (MalformedURLException ex) {
        Logger.getLogger(ProxyBean.class.getName()).log(Level.SEVERE, null, ex);
    }

    // ideally here you need return control to container
    // and resume processing inside responseCollector
    // when the last response is gotten. The problem is that JAX-WS does not
    // specify how to do async processing on server side (similar to Async Servlets in Servlets specification 3.x).
    // I know only one implementation that has an extension for async WebMethod -
    // JEUS, see https://technet.tmaxsoft.com/upload/download/online/jeus/pver-20160610-000001/web-service/chapter_jaxws_async_operation.html
    // So the only portable option here is to wait (using container thread).

    // 

    return null; //return recordset once all responses arrived (using blocking queue?)

}