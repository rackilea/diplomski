Collator collator = Collator.getInstance(Locale.FRENCH);
collator.setStrength(Collator.PRIMARY);

Map<String, String> map = new TreeMap<String, String>(collator);

map.put("ABC", "foo");

System.out.println(map.get("abc"));