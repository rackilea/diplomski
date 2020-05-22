ObjectMapper mapper = new ObjectMapper();

RandomObjectFiller randomObjectFiller = new RandomObjectFiller();

// PojoClass is the class created with xjc from your xsd
PojoClass pojoInstance = randomObjectFiller.createAndFill(PojoClass.class);

String jsonString = mapper.writeValueAsString(pojoInstance);
System.out.println(jsonString);  // Print the pojoInstance as json string