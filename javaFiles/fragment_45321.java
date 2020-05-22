public void subscribe(String msisdn) throws InvalidArgumentException {
    Map<String, Object> params = new HashMap<String, Object>();
    params.put("msisdn", msisdn);
    params.put("responseCode", null);
    subscriberMapper.canCustomerSubscribe(params);
    System.out.println(params.get("responseCode"));
}