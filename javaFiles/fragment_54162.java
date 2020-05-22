import java.util.*;
import java.lang.*;
import java.io.*;

class SubsetSum
{
    public static <T> Set<Set<T>> powerSet(Set<T> originalSet)
    {
        Set<Set<T>> sets = new HashSet<Set<T>>();
        if (originalSet.isEmpty()) 
        {
            sets.add(new HashSet<T>());
            return sets;
        }
        List<T> list = new ArrayList<T>(originalSet);
        T head = list.get(0);
        Set<T> rest = new HashSet<T>(list.subList(1, list.size())); 
        for (Set<T> set : powerSet(rest))
        {
            Set<T> newSet = new HashSet<T>();
            newSet.add(head);
            newSet.addAll(set);
            sets.add(newSet);
            sets.add(set);
        }       
        return sets;
    }

    public static void main(String[] args)
    {
        Set<Integer> mySet = new HashSet<Integer>();
        int[] arr={3, 5, 5, 7};
        int target = 10;
        int numVals = 4;
        for(int i=0;i<numVals;++i)
        {
            mySet.add(i);
        }
        System.out.println("Solutions: ");
        for (Set<Integer> s : powerSet(mySet)) 
        {
            int sum = 0;
            for (Integer e : s)
            {
                sum += arr[e];
            }
            if (sum == target)
            {
                String soln = "[ ";
                for (Integer e : s)
                {
                    soln += arr[e];
                    soln += " ";
                }
                soln += "]";

                System.out.println(soln);
            }
        }
    }
}