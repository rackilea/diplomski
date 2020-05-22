/* package whatever; // don't place package name! */

    import java.util.*;
    import java.lang.*;
    import java.io.*;



    class Ideone
    {

        public static void main (String[] args) throws java.lang.Exception
        {

        System.out.println("string");
        Scanner sc = new Scanner(System.in);
        System.out.println("enter string 1");
        String s1 = sc.next();
        System.out.println("enter string 2");
        String s2 = sc.next();
        Map<Character, Integer> m1s1 = new HashMap<>();
        Map<Character, Integer> m2s2 = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {

            if (m1s1.containsKey(s1.charAt(i))) {
                m1s1.put((Character) s1.charAt(i), m1s1.get((Character) 
        s1.charAt(i)) + 1);
            } else {

                m1s1.put((Character) s1.charAt(i), 1);

            }
        }
        for (int i = 0; i < s2.length(); i++) {

            if (m2s2.containsKey(s2.charAt(i))) {
                m2s2.put((Character) s2.charAt(i), m2s2.get((Character) 
         s2.charAt(i)) + 1);
            } else {
                m2s2.put((Character) s2.charAt(i), 1);

            }
        }
        System.out.println("m1s1....." + m1s1);
        System.out.println("m221...." + m2s2);

// ADDED MY CODE FROM HERE
// TAKEN STRING 1 AND MAP OF STRING 2, CHECK CHARACTER BY CHARACTER OF STRING 1 IN MAP //OF STRING 2, IF THE CHARACTER EXISTS PRINT IT & DECREASE ITS VALUE IN MAP BY 1 , IF //AFTER DECREASING THE VALUE BECOMES 0, REMOVE IT FROM MAP, IF THE CHARACTER OF //STRING1 DOES NOT EXIST IN MAP2 DON'T DO ANYTHING, FOLLOW ABOVE RULES FOR EVERY //CHARACTER OF STRING 1

// NOW TAKE STRING2 AND MAP OF STRING1 AND FOLLOW THE EXACT PROCEDURE ABOVE

        int i,x;
        char c;

        for(i=0;i<s1.length();i++)
        {
            c=s1.charAt(i);
            if(m2s2.containsKey(c))
            {
                System.out.print(c);
                x=m2s2.get((Character)c);
                x=x-1;
                if(x==0)
                    m2s2.remove(new Character(c));
                else
                    m2s2.put((Character) c,x);
            }
        }
                System.out.println();

            for(i=0;i<s2.length();i++)
        {
            c=s2.charAt(i);
            if(m1s1.containsKey(c))
            {
                System.out.print(c);
                x=m1s1.get((Character)c);
                x=x-1;
                if(x==0)
                    m1s1.remove(new Character(c));
                else
                    m1s1.put((Character) c,x);
            }
        }


        }
    }