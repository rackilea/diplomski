String uri =
    "http://localhost:8080/CustomerService/rest/customers/1";
URL url = new URL(uri);
HttpURLConnection connection =
    (HttpURLConnection) url.openConnection();
connection.setRequestMethod("GET");
connection.setRequestProperty("Accept", "application/xml");

JAXBContext jc = JAXBContext.newInstance(Customer.class);
InputStream xml = connection.getInputStream();
Customer customer =
    (Customer) jc.createUnmarshaller().unmarshal(xml);

connection.disconnect();