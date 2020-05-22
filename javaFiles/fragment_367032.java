ThreeLevelMap<String, String, String, String> tlm = new ThreeLevelMap<>();
tlm.put("Java", "Active", "Tags", "Java-OOP");
tlm.put("Java", "Active", "Tags", "Java-Variables");

Map<String, Multimap<String, String>> firstLevelMap = tlm.get("Java");
Multimap<String, String> secondLevelMap = tlm.get("Java", "Active");
Collection<String> tags = tlm.get("Java", "Active", "Tags");