public class Part0 {

        public static boolean forAllExists(int[] A) {
            boolean ans = true;
            for(int i=0; i<A.length; i++)
            {
                if(checkIfLargebyTen(A,i)==false)
                {
                    ans=false;
                }//if
            }//for

            return ans; // return missing in the OP
        } // close forAllExists - missing in the OP

       //Boolean function that check if  A[x]>A[y]-10
       static boolean checkIfLargebyTen(int[] arr, int x) {
          boolean ans=false;
              for(int y=0; y<arr.length && ans==false; y++)
               {
                if (x!=y && arr[x]>arr[y]-10)
                {
                    ans=true;
                }//if
            }//for
            return ans;
        }//CheckFunction
}//class