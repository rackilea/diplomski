data ts = new data();
ts.addAll(Arrays.asList(Arrays.asList(1234, 55), Arrays.asList(1264, 45), Arrays.asList(1334, 56)));

ObjectMapper objectMapper = new ObjectMapper();
objectMapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
String result = objectMapper.writeValueAsString(ts);

System.out.println(result);