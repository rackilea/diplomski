JSONArray list = new JSONArray();
  list.add("foo");
  list.add(new Integer(100));
  list.add(new Double(1000.21));
  list.add(new Boolean(true));
  list.add(null);
  StringWriter out = new StringWriter();
  list.writeJSONString(out);