public static void removeString(){

    String name1 = "1298 Anthony.ef 1298 Anthony.ef";

    String[] strArr = name1.split("\\W+");
    Set<String> set = new LinkedHashSet<String>(Arrays.asList(strArr));

    String[] result = new String[set.size()];
    set.toArray(result);
    StringBuilder res = new StringBuilder();
    for (int i = 0; i < result.length; i++) {
        String string = result[i];
        if(i==result.length-1){
            res.append(string);
        }
        else{
            res.append(string).append(" ");
        }

    }
    System.out.println(res.toString());
    String abc = res.toString();
}