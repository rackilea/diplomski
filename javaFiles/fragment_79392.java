private static boolean isPalindrome_Version_2 ( String s)
{
    boolean result = false;

    // BASE CASE
    if ( s.length() <= 1 ){
         System.out.println("Input Value :" + s + "Return Value" + true);
        return (true);

    // GENERAL CASE - check whether the substring formed by removing 
    //                the first and last letters is a palindrome
    result = isPalindrome_Version_2 ( s.substring ( 1, s.length() - 1 ) );

    // BASE CASE - check if first char equals last char
    if ( s.charAt(0)  !=  s.charAt ( s.length() - 1 ) )
   {
        System.out.println("Input Value :" + s + "Return Value" + false);
        return ( false );
   }

    System.out.println("Input Value :" + s + "Return Value" + result);
    return( result  );
}