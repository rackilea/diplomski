public static void countAInWord( String w , int n)
{

int aCount = 0; // Everytime you enter this recursive function, it will reset to 0, which should not be the case.
if ( n > 0 )
{
     if (w.charAt(n) == 'a')
     {
         aCount++;
         // Yeah you found an 'a', then what? You should call the recursive function again to continue checking. (like how you do it in the else function below)
     }
     else
     {
         n = n-1;
         countAInWord(w, n);
     }
 }
 else
     System.out.println("The number of A's is " + aCount);
   }
}