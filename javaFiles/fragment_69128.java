List<Map<String,String>> motherList = new ArrayList<>();
Map<String,String> workingChild = new HashMap<>();

.... 

String keyword = m.group(1);
String parameter = m.group(2);

workingChild.put(keyword,parameter);
if(!keyword.equals("n")) {
    motherList.add(workingChild);
    workingChild = new HashMap<>();
}