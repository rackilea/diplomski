ObjectMapper mapper = new ObjectMapper();

// PojoClass is the class created with xjc from your xsd
PojoClass pojoInstance = new PojoClass();  

// Populate pojoInstance as needed

String jsonString = mapper.writeValueAsString(pojoInstance);
System.out.println(jsonString);  // Print the pojoInstance as json string