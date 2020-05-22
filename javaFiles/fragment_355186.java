Map<String, Object> data = new HashMap<>();
data.put("network_id", new BigInteger("5000370004610700049753"));

ObjectMapper objectMapper = new ObjectMapper();

String plainJson = objectMapper.writeValueAsString(data);
System.out.println(plainJson);

String encodedJson = objectMapper.writeValueAsString(plainJson);
System.out.println(encodedJson);