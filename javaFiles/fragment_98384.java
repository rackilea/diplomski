public static final int findMaxRecursively(List<Integer> numbers) 
{
     if(numbers.size() == 1)
         return numbers.get(0);

     List<Integer> bottomHalf = numbers.subList(0,numbers.size()/2);
     int bottom = findMaxRecursively(bottomHalf);

     List<Integer> topHalf = numbers.subList(numbers.size()/2,numbers.size());
     int top = findMaxRecursively(topHalf);

     return top>bottom?top:bottom;
}