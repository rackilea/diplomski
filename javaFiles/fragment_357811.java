Map<String, List<String>> myObject = new HashMap<>();
myObject.put("smsBody", new ArrayList<>());
myObject.put("totalSMS", new ArrayList<>());
myObject.put("sender", new ArrayList<>());

List<String> totalSMS = myObject.get("totalSMS");
totalSMS.add("5");
totalSMS.add("10");

for (String s : totalSMS) {
    System.out.println(s);
}