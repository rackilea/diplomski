String[] input = {"aaa|bbb|ccc", "aaa?|bbb|ccc", "aaa?|bbb||ccc|||ddd"};
for (String s: input) {
    //                                          | negative lookbehind for "?" (escaped)
    //                                          |       | "|" (escaped)
    //                                          |       | 
    System.out.println(Arrays.toString(s.split("(?<!\\?)\\|")));
}