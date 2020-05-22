final String templateURL = "http://localhost:6061/customers/{customerId}";
final Map<String, String> variables = new HashMap<>();

variables.put("customerId", customerId);
...

template.getForObject(templateURL, String.class, variables);