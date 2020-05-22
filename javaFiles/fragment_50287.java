List<ArrayList<Integer>> mylist_list = new ArrayList<ArrayList<Integer>>(); 
ArrayList<Integer> mylist = new ArrayList<Integer>();
...
for(ArrayList<Integer> list : mylist_list)
{
    System.out.println(Arrays.toString(list.toArray()));
}
Set<ArrayList<Integer>> mylist_set = new HashSet<ArrayList<Integer>>(mylist_list);

for(ArrayList<Integer> list : mylist_set)
{
    System.out.println(Arrays.toString(list.toArray()));            
}