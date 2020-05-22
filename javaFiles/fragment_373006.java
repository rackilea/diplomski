int[] first = {1,2,3,4};
int[] second = {5,6,7,8};
List<int[]> all = new ArrayList<int[]>();
all.add(first);
all.add(second);
// no nice String representation here as Arrays.toString not explicitly invoked
System.out.println(all);