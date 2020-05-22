String json1 = "{\"cust_id\": \"87655\"}";
String json2 = "{\"cust_id\": [\"12345\", \"45678\"]}";

GsonBuilder gsonBuilder = new GsonBuilder();
gsonBuilder.registerTypeAdapter(Customer.class, new CustomerDeserializer());
Gson gson = gsonBuilder.create();

Customer customer1 = gson.fromJson(json1, Customer.class);
System.out.println(customer1);

Customer customer2 = gson.fromJson(json2, Customer.class);
System.out.println(customer2);