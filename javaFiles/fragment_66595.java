ObjectMapper mapper = new ObjectMapper();
HashMap<String, Object> data = new HashMap<String, Object>();
data.put("x", 1392440400000l);
data.put("title", "!");

HashMap<String, Object> data2 = new HashMap<String, Object>();
data2.put("x", 1392440400000l);
data2.put("title", "!");

List out = new ArrayList();
out.add(data);
out.add(data2);

String val = mapper.writeValueAsString(out);