List<Date> dates = ...;
List<List<Date>> dateList = new ArrayList<List<Date>>();

List<Date> currentList = new ArrayList<Date>();
for (Date date : dates)
{
   if (currentList.isEmpty())
   {
       currentList.add(date);
       continue;
   }

   Date lastDate = currentList.get(currentList.size() - 1);

   if (date is one day after lastDate)
   {
       currentList.add(date);
       continue;
   }

   dateList.add(currentList);
   currentList = new ArrayList<Date>();
   currentList.add(date);
}

if (!currentList.isEmpty())
   dateList.add(currentList);