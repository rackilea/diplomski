HashMap<String, InfoStor> mapper = new HashMap<String, InfoStor>();
mapper.put("NS01", new InfoStor("NS01"));
...

InfoStor value = mapper.get("NS01");
Integer memory = value.getMemory();