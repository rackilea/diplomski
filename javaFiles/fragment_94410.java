ObjectMapper mapper = new ObjectMapper();

OuterType response;
response = mapper.readValue(json, OuterType.class);

System.out.println(response);
System.out.println(response.getName().get(0).getStuff().get("234"));