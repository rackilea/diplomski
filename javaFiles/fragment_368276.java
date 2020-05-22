ObjectMapper objectMapper = new ObjectMapper();

StatusErrors result1 = objectMapper.readValue(JSON1, StatusErrors.class);
System.out.println(result1);
System.out.println(result1.getErrors().getClass());
System.out.println(result1.getErrorsMap());
StatusErrors result2 = objectMapper.readValue(JSON2, StatusErrors.class);
System.out.println(result2);