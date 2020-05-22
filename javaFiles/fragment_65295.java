Customer customer = Customer.retrieve(user.getStripeId());
// add a new payment source to the customer
Map<String, Object> params = new HashMap<String, Object>();
params.put("source", token.getId());
Source source = customer.getSources().create(params);

// make it the default
Map<String, Object> updateParams = new HashMap<String, Object>();
updateParams.put("default_source", source.getId());
customer.update(updateParams);