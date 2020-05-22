private static boolean isPalindrome_Version_2 ( String s, int level)
{
    boolean result = false;

    // BASE CASE
    if ( s.length() <= 1 ){
         System.out.println("Input Value :" + s + "Return Value" + true + "Recursion Level" + level);
        return (true);

    // GENERAL CASE - check whether the substring formed by removing 
    //                the first and last letters is a palindrome
    result = isPalindrome_Version_2 ( s.substring ( 1, s.length() - 1 ), level ++ );

    // BASE CASE - check if first char equals last char
    if ( s.charAt(0)  !=  s.charAt ( s.length() - 1 ) )
   {
        System.out.println("Input Value :" + s + "Return Value" + false+ "Recursion Level" + level);
        return ( false );
   }

    System.out.println("Input Value :" + s + "Return Value" + result+ "Recursion Level" + level);
    return( result  );
}