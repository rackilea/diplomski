public static <T> void reverse(List<T> list) 
{ 
    List<T> tmp = new ArrayList<> (list);
    for (int i = 0; i < list.size(); i++)  {
        list.set(i, tmp.get(list.size()-i-1));
    }
}