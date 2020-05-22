String s = "102, 145, 163, 124";
String[] sArray = s.split(",");
List<Integer> integers = new ArrayList<Integer>();
for(String item:sArray){
  integers.add(Integer.parseInt(s.replace(",","")));
}