public class RefCheckForStrings {

    StringBuilder sb=new StringBuilder("abc");
    {
        sb.append("def");  
        System.out.println(sb);   
    }
    String s="abc";
    {
        s.concat("def");    
        System.out.println(s);
    }
}