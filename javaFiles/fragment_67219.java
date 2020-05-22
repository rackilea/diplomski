JSONObject obj=new JSONObject();
  obj.put("name","foo");
  obj.put("num",new Integer(100));
  obj.put("balance",new Double(1000.21));
  obj.put("is_vip",new Boolean(true));
  obj.put("nickname",null);
  System.out.print(obj);


Result: {"balance":1000.21,"num":100,"nickname":null,"is_vip":true,"name":"foo"}