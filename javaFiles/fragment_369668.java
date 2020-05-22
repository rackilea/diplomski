ObjectMapper mapper = new ObjectMapper();

Properties p = new Properties();
p.put("apple", "peter");
p.put("orange", "annoying");
p.put("quantity", 3);
mapper.writeValue(System.out, p);