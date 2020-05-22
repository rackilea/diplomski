public static Object nthToLast(int n, LinkedList list)
{
    int len = list.size();
    if(n<0 || len < n){
      return null;
    }
    return list.get(len-n);
}