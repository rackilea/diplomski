String[] image = new String[] {"APP","FIELD","KYC"};
String[] image2 = new String[] {"MEMORANDUM","ASSOCIATION"};
List<String> list = new ArrayList<String>(Arrays.asList(image));
list.addAll(Arrays.asList(image2));
String[] result = list.toArray(new String[]{});
System.out.println(Arrays.toString(result));