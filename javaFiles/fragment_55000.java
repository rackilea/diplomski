Integer[] a = {1,2,3,4,5};
Integer[] b = {2,4,5,6,7,8,9};
Set<Integer> s1 = new HashSet<>(Arrays.asList(a));
Set<Integer> s2 = new HashSet<>(Arrays.asList(b));
s1.retainAll(s2);

Integer[] result = s1.toArray(new Integer[s1.size()]);
System.out.println(Arrays.toString(result));