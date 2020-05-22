JSONObject jsonobj=new JSONObject();
JSONArray obj = new JSONArray();
HashMap rows=new HashMap();
rows.put("rank","1");
rows.put("country","China");
rows.put("population","1,354,040,000");
rows.put("flag","http://www.androidbegin.com/tutorial/flag/china.png");
obj.put(rows);

rows=new HashMap();
rows.put("rank","2");
rows.put("country","India");
rows.put("population","1,210,193,422");
rows.put("flag","http://www.androidbegin.com/tutorial/flag/india.png");
obj.put(rows);

rows=new HashMap();
rows.put("rank","3");
rows.put("country","United States");
rows.put("population","315,761,000");
rows.put("flag","http://www.androidbegin.com/tutorial/flag/unitedstates.png");

jsonobj.put("worldpopulation", obj);

System.out.println(jsonobj.toString());