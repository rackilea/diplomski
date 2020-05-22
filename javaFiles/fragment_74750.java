public void findInRange(int num, int numb)
{
 for(String eachName: names.keySet())
 {
   pageNum = names.get(eachName);
   for (int eachNum:pageNum)
   {
    if(eachNum>=num&&eachNum<=numb||eachNum>=numb&&eachNum<=num)
    {
        System.out.println(eachName);
        break;
    }
   }
 }
}