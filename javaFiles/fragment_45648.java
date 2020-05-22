List<Integer> list = new ArrayList<Integer>();
list.add(3);
list.add(10);
list.add(9);
list.add(11);
list.add(10);
list.add(2);
list.add(9);

List<Integer> result = new ArrayList<Integer>();
double lowerFactor = 0.8d;
double upperFactor = 1.2d;

double lowerLimit = list.get(0) * lowerFactor;
double upperLimit = list.get(0) * upperFactor;
int index = 1;
do
{
     if (lowerLimit <= list.get(index) && list.get(index) <= upperLimit)
     {
         if (result.isEmpty())
         {
             result.add(list.get(index - 1));
         }
         result.add(list.get(index));
     } else if (result.size() > 0)
     {
         break;
     } else
     {
         lowerLimit = lowerFactor * list.get(index);
         upperLimit = upperFactor * list.get(index);
     }
     index++;
} while (index < list.size());