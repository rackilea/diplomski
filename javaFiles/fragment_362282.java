import java.util.ArrayList;
import java.util.List;

public class WhatSoEver{

    static int order;

    public static void main(String[] args) {

        ArrayList<String> approved = new ArrayList<>();
        approved.add("abc");
        approved.add("def");
        approved.add("ghi");
        approved.add("def jkl ggwp my life");
        approved.add("jkl");
        approved.add("mno");
        approved.add("pqr");
        approved.add("stu vwx");
        approved.add("yz");

        System.out.println(isValid(approved, "abc def")); // true
        System.out.println(isValid(approved, "stu vwx yz")); // true
        System.out.println(isValid(approved, "ghi")); // true
        System.out.println(isValid(approved, "vwx yz")); // true        

        System.out.println(isValid(approved, "yza")); // false
        System.out.println(isValid(approved, "ghi jk")); //false
        System.out.println(isValid(approved, "pqr stu v")); //false
        System.out.println(isValid(approved, "def abc")); //false

    }

    public static boolean isValid(List<String> approved, String userInput){
        order=0;
        for(String word : userInput.split(" ")){
            if(!containsWord(approved, word)){
                return false;
            }
        }
        return true;
    }

    private static boolean containsWord(List<String> approved, String word){
         for(int i=0; i<approved.size(); i++){
            for(String subS : approved.get(i).split(" ")){
               if(word.equals(subS) && (i+1)>order){
                      order=i;
                      return true;
               }
            }
         }
         return false;
     }
}