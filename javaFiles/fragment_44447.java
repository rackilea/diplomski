public void handle(HttpServletRequest request) {   

    Stripe.apiKey = sk_test_XXXXXXXXXXXXXXXXXXXX;

    String rawJson = "";

    try {
         rawJson = IOUtils.toString(request.getInputStream());
    } 
    catch (IOException ex) {
       System.out.println("Error extracting json value : " + ex.getMessage());
    }

    Event event = APIResource.GSON.fromJson(rawJson, Event.class);
    System.out.println("Webhook event : " + event);

    // Converting event object to map
    ObjectMapper m = new ObjectMapper();
    @SuppressWarnings("unchecked")
    Map<String, Object> props = m.convertValue(event.getData(), Map.class);

    // Getting required data
    Object dataMap = props.get("object");

    @SuppressWarnings("unchecked")
    Map<String, String> objectMapper = m.convertValue(dataMap, Map.class);

    String invoiceId = objectMapper.get("id");

    System.out.println("invoideId : " + invoiceId);
}