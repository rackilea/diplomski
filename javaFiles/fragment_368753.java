Map<String, String> map = new HashMap<String, String>();
map.put("FirstName", "LastName");

System.out.println(map.get("FirstName")); // Prints 'LastName'
System.out.println(map.put("FirstName", "Foo")); // Prints 'LastName'
System.out.println(map.get("FirstName")); // Prints 'Foo'