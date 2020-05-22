String text = "The user {name} has email address {email}.";
Map map = new HashMap();
map.put("name", "Robert");
map.put("email", "rhume55@gmail.com");

System.out.println("1st : " + MapFormat.format(text, map));