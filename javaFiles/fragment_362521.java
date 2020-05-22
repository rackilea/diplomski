String text = "text(24), text_2(5), text_4(822)";

Map<String, Integer> map = new HashMap<>();

String[] split = text.split(", ");

for(String s:split){
    //search for the position of "(" and ")"
    int start = 0;
    int end = s.length()-1;
    while(s.charAt(start) != '(')
        start++;
    while(s.charAt(end) != ')')
        end--;
    //put string and matching value in the map
    map.put(s.substring(0, start), Integer.parseInt(s.substring(start+1, end)));
}

System.out.println(map);