public static Matches findMatches(int[] values, int query) 
{
 int firstMatchIndex = -1,lastMatchIndex=-1;
 int low = 0,mid = 0,high = values.length - 1;
 while (low <= high)
 {
      mid = (low + high)/2;

      if(values[mid]==query)
      {
          lastMatchIndex=mid;
          firstMatchIndex=mid;
          while(lastMatchIndex+1<values.length&&values[lastMatchIndex+1]==query)
           lastMatchIndex++;
          while(firstMatchIndex-1>=0&&values[firstMatchIndex-1]==query)
           firstMatchIndex--; 
          return new Matches(firstMatchIndex,lastMatchIndex-firstMatchIndex+1); 
      }
      else if(values[mid]>query)
       high=mid-1;
      else low=mid+1;
 }
 return new Matches(-1,0);
}