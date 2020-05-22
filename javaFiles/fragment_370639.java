public class RefCheckForStrings {

        StringBuilder sb;
        String s;

       public RefCheckForStrings()
       {
               sb=new StringBuilder("abc");
               s = "abc";
               sb.append("def"); 
                s.concat("def");
       }
}