List<String> lista = Arrays.asList("a1","a2");
List<String> listb = Arrays.asList("b1","b2","b3");
List<String> listc = Arrays.asList("c1","c2");

List<List<String>> result = new ArrayList<List<String>>();
for (String a: lista) {
    for (String b: listb) {
        for (String c: listc) {
            result.add(Arrays.asList(a, b, c));
        }
    }
}
System.out.println(result);