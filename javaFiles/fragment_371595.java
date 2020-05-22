int i = 0;
String s = "";
for (Integer num : nums) { 
  s += num;
  if (++i < ints.size()) s += ", ";
}