String str = "digraph G {\nnode [shape=circle];\n0 [xlabel=\"[]\"];\n1 [xlabel=\"[[Text]]\"];\n0 -> 1 [label=\"a\"];//this\n1 -> 2 [label=\"ab\"];//this\n1 -> 3 [label=\"123\"];//this\n}"; 
Pattern ptrn = Pattern.compile("(?m)^(\\d+)\\s+->\\s+(\\d+)\\s+\\[\\w+=\"([^\"]*)\"\\];\\s*//[^/\n]*$");
Matcher m = ptrn.matcher(str);
ArrayList<String[]> results = new ArrayList<String[]>();
while (m.find()) {
    results.add(new String[]{m.group(1), m.group(2), m.group(3)});
}
for(int i = 0; i < results.size(); i++) {               // Display results
    System.out.println(Arrays.toString(results.get(i)));
}