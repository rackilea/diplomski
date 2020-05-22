public List<List<Object>> partionList( List<Object> yourList, int numPartitions)
{
   List<List<Object>> resultList = new ArrayList<List<Object>>();
   for(int i = 0; i < numPartitions; i++)
       resultList.add(new ArrayList<Object>());

   int counter = 0;
   for(Object o:yourList)
   {
       resultList.get(counter % numPartitions).add(o);           
       counter++;
   }
   return resultList
}