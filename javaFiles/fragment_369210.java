Map<String, ArrayList<String>> m = new HashMap<String, ArrayList<String>>();

ArrayList<String> arr = new ArrayList<String>();
arr.add("value1");
arr.add("value2");

m.put("key", arr);

System.out.println(m); // {key=[value1, value2]}