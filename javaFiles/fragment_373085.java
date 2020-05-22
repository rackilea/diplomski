SystemInfo system1 = new SystemInfo();
system1.setSystemName("The Name");
// etc.

Map<String, SystemInfo> systemMap = new HashMap<String, SystemInfo>();
systemMap.put(system1.getSystemName(), system1);