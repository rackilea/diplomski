Map<String, String> propertyToLabelMap = new HashMap<String, String>();
propertyToLabelMap.put("name", "Full Name");
propertyToLabelMap.put("groupNumber", "Group");
propertyToLabelMap.put("examName", "Name");
propertyToLabelMap.put("examMark", "Mark");

...

DefaultColumnHeaderDataProvider defaultColumnHeaderDataProvider = new DefaultColumnHeaderDataProvider(propertyNames, propertyToLabelMap);