String input = "Tammy,Tあmmy,John Jones KO'd Machida,The Drall,あい";
StringBuilder builder = new StringBuilder();
Map<Character, CharSequence> map = new HashMap<>();
map.put('あ', "a");
map.put('a', "aa");
map.put('c', "k");

for (char c : input.toCharArray()) {
    if (map.containsKey(c)) {
        builder.append(map.get(c));
    } else {
        builder.append(c);
    }
}

System.out.println(builder.toString());