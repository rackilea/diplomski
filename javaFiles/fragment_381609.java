/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
public static void main (String[] args) throws java.lang.Exception
{

    // your code goes here
    Map<Integer,Integer> map1=new HashMap<Integer,Integer>();
    int A[]={1 , 3 , 5 , 7 ,9 };
    int B[]={1 ,3 , 4 ,5 , 6 ,7 , 10};
    int i;
    for(i=0;i<B.length;i++)
    map1.put(B[i],1);
    for(i=0;i<A.length;i++)
    {

            Integer v1=map1.get(A[i]);
        if(v1==null)
        {

            System.out.println("Missing number="+A[i]);
        }

    }

    for(i=0;i<A.length;i++)
    {

        Integer v1=map1.get(A[i]);

        if(v1!=null)
        {int val=v1;
            map1.put(A[i],val+1);

    //      System.out.println("Missing number="+A[i]);
        }

    }
    for(i=0;i<B.length;i++)
    {
            Integer v1=map1.get(B[i]);
        if(v1!=null && v1<2)
        {

            System.out.println("Added element in B="+B[i]);
        }

    }


}
}