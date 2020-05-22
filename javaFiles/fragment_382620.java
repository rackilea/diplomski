Map<Character, Character> m = new HashMap<>();
m.put('F','0');
....

StringBuilder sb = new StringBuilder();
for(char c : originalString.toCharArray()){
   sb.append(map.get(Character.toUpperCase(c)));
} 
String finalString = sb.toString();