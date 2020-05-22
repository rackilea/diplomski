ArrayList<ArrayList<Integer>> list2d = new ArrayList<ArrayList<Integer>>();
// add an element to the list
list2d.add(new ArrayList<Integer>());
// retrieve a list 
ArrayList<Integer> list1d = list2d.get(0);
// add an integer
list2d.get(0).add(123);