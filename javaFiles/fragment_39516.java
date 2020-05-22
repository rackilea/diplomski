// Create a random UUID:
UUID uuid1 = UUID.randomUUID();
System.out.println(uuid1);

// Create a fixed UUID:
String uuidString = "D00077B4-EBFB-4BD8-9E3F-1F3943CBCE35";
UUID uuid2 = UUID.fromString(uuidString);
System.out.println(uuid2);

// Get string from UUID:
UUID uuid = ...
String s = uuid.toString();
System.out.println(s);