int doSomething(int i)
{
    List<Integer> list = new ArrayList<Integer>(
        Arrays.asList(1,2,3,4,5,6,7,8,9,10));
    Collections.sort(list);
    return list.get(i);
}