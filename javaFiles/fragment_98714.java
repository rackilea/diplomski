public class Solution {

public static void main(String[] args) {
    String s1 ="aabbccaassssASaatestaa";
    String s2 = "aa";
    // split the string S1 by  s2 
    String a[] = s1.split(s2); 


    //Output will be 4 - because 'aa' 4 times in s1
    System.out.println(a.length);
}
}

Output - 4