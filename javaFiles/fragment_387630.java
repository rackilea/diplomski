String input = "3hr 4min 5sec";
int sum = 0;
String[] arr = input.split(" ");
for(String s:arr){
  if(s.endsWith("hr"))
    sum += Integer.valueOf(s.substring(0, s.indexOf("hr"))) * 3600;
  if(s.endsWith("min"))
    sum += Integer.valueOf(s.substring(0, s.indexOf("min"))) * 60;
  if(s.endsWith("sec"))
    sum += Integer.valueOf(s.substring(0, s.indexOf("sec")));
}
System.out.println(sum);