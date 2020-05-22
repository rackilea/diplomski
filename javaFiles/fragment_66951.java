Hashtable h = new Hashtable();
Hashtable h1 = new Hashtable();h1.put("SOURCE","D");h1.put("NAME","D");
Hashtable h2 = new Hashtable();h2.put("SOURCE","C");h2.put("NAME","C");
Hashtable h3 = new Hashtable();h3.put("SOURCE","B");h3.put("NAME","B");
Hashtable h4 = new Hashtable();h4.put("SOURCE","A");h4.put("NAME","A");
h.put(new Long(4),h1);h.put(new Long(3),h2);h.put(new Long(2),h3);h.put(new Long(1),h1);


request.setAttribute("missing_ciphers",h);