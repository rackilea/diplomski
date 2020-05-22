String[] names = {"Dan", "Bob", "Kris"};
java.util.Collections.sort(java.util.Arrays.asList(names), new java.util.Comparator<String>() {
    @Override
    public int compare(String s1, String s2) {
        // TODO: Argument validation (nullity, length)
        return s1.charAt(1) - s2.charAt(1);//comparision
    }  
});

for (String name : names) System.out.println(name);