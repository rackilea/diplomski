Map<String, InfoStor> mapper = new HashMap<>();
mapper.put("NS01", new InfoStor("NS01"));
...

InfoStor value = mapper.get("NS01");
Integer memory = value.getMemory();