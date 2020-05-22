String s = "dummy:10.45someObjectdummy:10.67somethingdummy:10.78somethingdummy:10.98djd";
Matcher m = Pattern.compile("dummy:(\\d+\\.\\d+)").matcher(s);
List<Double> vals = new ArrayList<>();
while (m.find()){
    vals.add(Double.parseDouble(m.group(1)));  // Collecting matches
} 
int val_id = vals.size() / 2 - 1;           // Finding out the index of the value to update
Double updated_val = vals.get(val_id);      // Getting the value
// System.out.println("We need to update " + updated_val); // => We need to update 10.67
updated_val = updated_val + 1;             // Incrementing the value
String replace_pattern = "(dummy:(?:\\d+\\.\\d.*?dummy:){" + (val_id) + "})\\d+\\.\\d+";
// System.out.println("New pattern: " + replace_pattern); // => New pattern: (dummy:(?:\d+\.\d.*?dummy:){1})\d+\.\d+
String result = s.replaceFirst(replace_pattern, "$1" + updated_val); // Replacing
System.out.println(result);
// => dummy:10.45someObjectdummy:11.67somethingdummy:10.78somethingdummy:10.98djd