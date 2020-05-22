// cannot use primitive arrays in this context without tedious iteration
Integer[] first = {1,2,3,4};
Integer[] second = {5,6,7,8};
List<List<Integer>> all = new ArrayList<List<Integer>>();
all.add(Arrays.asList(first));
all.add(Arrays.asList(second));
System.out.println(all);