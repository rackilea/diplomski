@Override
public int compare(Record x, Record y)
{
   // First compare times
   int result = x.getTime().compareTo(y.getTime());
   if(result != 0)
      return result;

   // sortOrders is your map
   return sortOrders.get(x.getClass()).compareTo(sortOrders.get(y.getClass()));
}