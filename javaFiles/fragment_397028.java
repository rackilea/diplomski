public static final int findMaxRecursively(List<Integer> numbers) 
{
     if(numbers.size() == 1)
         return numbers.get(0);

     int bottom = findMaxRecursively(numbers.subList(0,numbers.size()/2));

     int top = findMaxRecursively(numbers.subList(numbers.size()/2,numbers.size()));

     return top>bottom?top:bottom;
}