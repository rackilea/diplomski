HashMap<String, Abc> abcMap = new HashMap<String, Abc>();
Abc abcObj = new Abc();
abcObj.setFirst_name("Jeet");
abcObj.setLast_name("Adhikari");
abcMap.put(abcObj.getFirst_name(), abcObj);

Abc abcObj2 = new Abc();
abcObj2.setFirst_name("John");
abcObj2.setLast_name("Something");
abcMap.put(abcObj2.getFirst_name(), abcObj2);