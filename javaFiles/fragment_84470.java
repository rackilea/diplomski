import  java.util.Iterator;
import  java.util.Map;
import  java.util.Set;
import  java.util.TreeMap;
/**
   <P>{@code java FindElementsThatAreSumsOfOthers}</P>
 **/
public class FindElementsThatAreSumsOfOthers  {
   public static final void main(String[] igno_red)  {
      int[] ai = new int[]{10, 51, 137, 464, 589, 61, 452};

      //All numbers in a map, key is array-value, value is array-index
      Map<Integer,Integer> mpValIdxAll = new TreeMap<Integer,Integer>();

      for(int i = 0; i < ai.length; i++)  {
         mpValIdxAll.put(ai[i], i);
      }

      //Only those elements in the array that are *sums* of other elements
      //Key is array-index of sum, value is SumInfo object
      Map<Integer,SumInfo> mpValIdxSums = new TreeMap<Integer,SumInfo>();

      for(int i = 0; i < ai.length; i++)  {
         //j + 1: So we don't test the same combination twice.
         for(int j = i + 1; j < ai.length; j++)  {
            int iSum = ai[i] + ai[j];

            if(mpValIdxAll.containsKey(iSum))  {
               //The all-map contains the sum, so add it to the sum-map
               mpValIdxSums.put(mpValIdxAll.get(iSum), new SumInfo(ai[i], i, ai[j], j));
            }
         }
      }

      Set<Integer> stSumIdxs = mpValIdxSums.keySet();
      Iterator<Integer> itrSumIdxs = stSumIdxs.iterator();
      while(itrSumIdxs.hasNext())  {
         int iIdxSum = itrSumIdxs.next();
         SumInfo si = mpValIdxSums.get(iIdxSum);
         System.out.println(ai[iIdxSum] + " (element " + iIdxSum + ")  is the sum of elements " + si.iA + " (idx=" + si.iIdxA + ") and " + si.iB + " (idx=" + si.iIdxB + ")");
      }
   }
}
//The two elements that are a sum of another element
class SumInfo  {
   public final int iA;
   public final int iIdxA;
   public final int iB;
   public final int iIdxB;
   public SumInfo(int i_addendA, int i_ndexA, int i_addendB, int i_ndexB)  {
      iA = i_addendA;
      iIdxA = i_ndexA;
      iB = i_addendB;
      iIdxB = i_ndexB;
   }
}